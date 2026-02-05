package net.paulem.aihorde4j.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.paulem.aihorde4j.exception.AiHordeApiException;
import net.paulem.aihorde4j.exception.AiHordeException;
import net.paulem.aihorde4j.model.RequestError;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

/**
 * HTTP client for making requests to the AI Horde API.
 */
public class AiHordeHttpClient {
    private static final String DEFAULT_BASE_URL = "https://aihorde.net/api";
    private static final String DEFAULT_CLIENT_AGENT = "AiHorde4J:1.0.0:https://github.com/Paulem79/AiHorde4J";

    private final HttpClient httpClient;
    private final Gson gson;
    private final String baseUrl;
    private final String apiKey;
    private final String clientAgent;

    public AiHordeHttpClient(String apiKey) {
        this(apiKey, DEFAULT_BASE_URL);
    }

    public AiHordeHttpClient(String apiKey, String baseUrl) {
        this(apiKey, baseUrl, DEFAULT_CLIENT_AGENT);
    }

    public AiHordeHttpClient(String apiKey, String baseUrl, String clientAgent) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.clientAgent = clientAgent;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    /**
     * Perform a GET request.
     */
    public <T> T get(String path, Class<T> responseType) {
        return get(path, responseType, Map.of());
    }

    /**
     * Perform a GET request with query parameters.
     */
    public <T> T get(String path, Class<T> responseType, Map<String, String> queryParams) {
        String url = buildUrl(path, queryParams);
        HttpRequest request = buildRequest(url)
                .GET()
                .build();
        return execute(request, responseType);
    }

    /**
     * Perform a GET request returning a list.
     */
    public <T> T get(String path, Type responseType) {
        return get(path, responseType, Map.of());
    }

    /**
     * Perform a GET request with query parameters returning a list.
     */
    public <T> T get(String path, Type responseType, Map<String, String> queryParams) {
        String url = buildUrl(path, queryParams);
        HttpRequest request = buildRequest(url)
                .GET()
                .build();
        return execute(request, responseType);
    }

    /**
     * Perform a POST request.
     */
    public <T> T post(String path, Object body, Class<T> responseType) {
        String url = buildUrl(path, Map.of());
        String jsonBody = body != null ? gson.toJson(body) : "";
        HttpRequest request = buildRequest(url)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .header("Content-Type", "application/json")
                .build();
        return execute(request, responseType);
    }

    /**
     * Perform a PUT request.
     */
    public <T> T put(String path, Object body, Class<T> responseType) {
        String url = buildUrl(path, Map.of());
        String jsonBody = body != null ? gson.toJson(body) : "";
        HttpRequest request = buildRequest(url)
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .header("Content-Type", "application/json")
                .build();
        return execute(request, responseType);
    }

    /**
     * Perform a PATCH request.
     */
    public <T> T patch(String path, Object body, Class<T> responseType) {
        String url = buildUrl(path, Map.of());
        String jsonBody = body != null ? gson.toJson(body) : "";
        HttpRequest request = buildRequest(url)
                .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonBody))
                .header("Content-Type", "application/json")
                .build();
        return execute(request, responseType);
    }

    /**
     * Perform a DELETE request.
     */
    public <T> T delete(String path, Class<T> responseType) {
        String url = buildUrl(path, Map.of());
        HttpRequest request = buildRequest(url)
                .DELETE()
                .build();
        return execute(request, responseType);
    }

    private HttpRequest.Builder buildRequest(String url) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Client-Agent", clientAgent)
                .timeout(Duration.ofMinutes(2));

        if (apiKey != null && !apiKey.isEmpty()) {
            builder.header("apikey", apiKey);
        }

        return builder;
    }

    private String buildUrl(String path, Map<String, String> queryParams) {
        StringBuilder url = new StringBuilder(baseUrl);
        url.append(path);

        if (!queryParams.isEmpty()) {
            url.append("?");
            queryParams.forEach((key, value) -> {
                if (value != null && !value.isEmpty()) {
                    url.append(key).append("=").append(value).append("&");
                }
            });
            url.deleteCharAt(url.length() - 1);
        }

        return url.toString();
    }

    private <T> T execute(HttpRequest request, Class<T> responseType) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return handleResponse(response, responseType);
        } catch (IOException | InterruptedException e) {
            throw new AiHordeException("Failed to execute request", e);
        }
    }

    private <T> T execute(HttpRequest request, Type responseType) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return handleResponse(response, responseType);
        } catch (IOException | InterruptedException e) {
            throw new AiHordeException("Failed to execute request", e);
        }
    }

    private <T> T handleResponse(HttpResponse<String> response, Class<T> responseType) {
        int statusCode = response.statusCode();
        String body = response.body();

        if (statusCode >= 200 && statusCode < 300) {
            if (body == null || body.isEmpty() || responseType == Void.class) {
                return null;
            }
            return gson.fromJson(body, responseType);
        }

        handleError(statusCode, body);
        return null;
    }

    private <T> T handleResponse(HttpResponse<String> response, Type responseType) {
        int statusCode = response.statusCode();
        String body = response.body();

        if (statusCode >= 200 && statusCode < 300) {
            if (body == null || body.isEmpty()) {
                return null;
            }
            return gson.fromJson(body, responseType);
        }

        handleError(statusCode, body);
        return null;
    }

    private void handleError(int statusCode, String body) {
        RequestError error = null;
        try {
            error = gson.fromJson(body, RequestError.class);
        } catch (Exception e) {
            // Could not parse error response
        }

        if (error != null) {
            throw new AiHordeApiException(error.message(), error.errorCode(), statusCode);
        } else {
            throw new AiHordeApiException("HTTP " + statusCode + ": " + body, null, statusCode);
        }
    }

    public Gson getGson() {
        return gson;
    }
}
