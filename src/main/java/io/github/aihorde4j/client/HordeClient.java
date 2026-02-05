package io.github.aihorde4j.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.aihorde4j.api.HordeApi;
import io.github.aihorde4j.dto.params.ModelGenerationInputKobold;
import io.github.aihorde4j.dto.params.ModelGenerationInputStable;
import io.github.aihorde4j.dto.request.GenerationInputKobold;
import io.github.aihorde4j.dto.request.GenerationInputStable;
import io.github.aihorde4j.dto.response.*;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * Main client for interacting with the AI Horde API.
 * This client is thread-safe and supports both synchronous and asynchronous operations.
 */
public class HordeClient implements AutoCloseable {
    
    /**
     * Default base URL for the AI Horde API.
     */
    public static final String DEFAULT_BASE_URL = "https://stablehorde.net/api/";
    
    /**
     * Default anonymous API key.
     */
    public static final String DEFAULT_API_KEY = "0000000000";
    
    /**
     * Default polling interval in milliseconds.
     */
    public static final long DEFAULT_POLL_INTERVAL_MS = 5000;
    
    /**
     * Default timeout for generation requests in seconds.
     */
    public static final long DEFAULT_GENERATION_TIMEOUT_SECONDS = 600;
    
    private final HordeApi api;
    private final String apiKey;
    private final String clientAgent;
    private final long pollIntervalMs;
    private final long generationTimeoutSeconds;
    private final ExecutorService executor;
    
    private HordeClient(Builder builder) {
        this.apiKey = builder.apiKey;
        this.clientAgent = builder.clientAgent;
        this.pollIntervalMs = builder.pollIntervalMs;
        this.generationTimeoutSeconds = builder.generationTimeoutSeconds;
        this.executor = Executors.newCachedThreadPool(r -> {
            Thread t = new Thread(r, "horde-client-worker");
            t.setDaemon(true);
            return t;
        });
        
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(30))
                .readTimeout(Duration.ofSeconds(60))
                .writeTimeout(Duration.ofSeconds(30));
        
        if (builder.enableLogging) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(loggingInterceptor);
        }
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.baseUrl)
                .client(httpClientBuilder.build())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        
        this.api = retrofit.create(HordeApi.class);
    }
    
    /**
     * Creates a new builder for HordeClient.
     *
     * @return A new builder instance
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Creates a default client with anonymous access.
     *
     * @return A new HordeClient with default configuration
     */
    public static HordeClient createDefault() {
        return builder().build();
    }
    
    /**
     * Creates a client with the specified API key.
     *
     * @param apiKey The API key to use
     * @return A new HordeClient
     */
    public static HordeClient withApiKey(String apiKey) {
        return builder().apiKey(apiKey).build();
    }
    
    // ==================== Low-level API Access ====================
    
    /**
     * Gets the underlying Retrofit API interface for direct access.
     *
     * @return The HordeApi interface
     */
    public HordeApi getApi() {
        return api;
    }
    
    // ==================== Image Generation ====================
    
    /**
     * Submits an image generation request.
     *
     * @param request The generation request
     * @return The async request containing the job ID
     * @throws HordeException if the request fails
     */
    public RequestAsync submitImageGeneration(GenerationInputStable request) {
        return executeCall(api.generateImageAsync(apiKey, clientAgent, request));
    }
    
    /**
     * Checks the status of an image generation request.
     *
     * @param requestId The request ID from submitImageGeneration
     * @return The status check result
     * @throws HordeException if the request fails
     */
    public RequestStatusCheck checkImageGeneration(String requestId) {
        return executeCall(api.checkImageGeneration(requestId));
    }
    
    /**
     * Gets the full status and results of an image generation request.
     *
     * @param requestId The request ID
     * @return The full status with generated images
     * @throws HordeException if the request fails
     */
    public RequestStatusStable getImageGenerationStatus(String requestId) {
        return executeCall(api.getImageGenerationStatus(requestId));
    }
    
    /**
     * Cancels a pending image generation request.
     *
     * @param requestId The request ID
     * @return The status after cancellation
     * @throws HordeException if the request fails
     */
    public RequestStatusStable cancelImageGeneration(String requestId) {
        return executeCall(api.cancelImageGeneration(requestId));
    }
    
    /**
     * Generates an image synchronously, polling until completion.
     *
     * @param prompt The prompt for image generation
     * @return The result containing generated images
     * @throws HordeException if the generation fails
     */
    public RequestStatusStable generateImage(String prompt) {
        return generateImage(prompt, null, null, null);
    }
    
    /**
     * Generates an image synchronously with custom parameters.
     *
     * @param prompt The prompt for image generation
     * @param params Optional generation parameters
     * @param models Optional list of models to use
     * @param progressCallback Optional callback for progress updates
     * @return The result containing generated images
     * @throws HordeException if the generation fails
     */
    public RequestStatusStable generateImage(
            String prompt,
            ModelGenerationInputStable params,
            List<String> models,
            GenerationProgressCallback progressCallback
    ) {
        GenerationInputStable request = GenerationInputStable.builder()
                .prompt(prompt)
                .params(params)
                .models(models)
                .build();
        
        return generateImage(request, progressCallback);
    }
    
    /**
     * Generates an image synchronously with a full request object.
     *
     * @param request The full generation request
     * @param progressCallback Optional callback for progress updates
     * @return The result containing generated images
     * @throws HordeException if the generation fails
     */
    public RequestStatusStable generateImage(
            GenerationInputStable request,
            GenerationProgressCallback progressCallback
    ) {
        RequestAsync asyncResponse = submitImageGeneration(request);
        String requestId = asyncResponse.getId();
        
        if (requestId == null) {
            throw new HordeException("No request ID returned: " + asyncResponse.getMessage());
        }
        
        return pollForImageCompletion(requestId, progressCallback);
    }
    
    /**
     * Generates an image asynchronously.
     *
     * @param prompt The prompt for image generation
     * @return A CompletableFuture that completes with the result
     */
    public CompletableFuture<RequestStatusStable> generateImageAsync(String prompt) {
        return generateImageAsync(prompt, null, null, null);
    }
    
    /**
     * Generates an image asynchronously with custom parameters.
     *
     * @param prompt The prompt for image generation
     * @param params Optional generation parameters
     * @param models Optional list of models to use
     * @param progressCallback Optional callback for progress updates
     * @return A CompletableFuture that completes with the result
     */
    public CompletableFuture<RequestStatusStable> generateImageAsync(
            String prompt,
            ModelGenerationInputStable params,
            List<String> models,
            GenerationProgressCallback progressCallback
    ) {
        return CompletableFuture.supplyAsync(() -> 
            generateImage(prompt, params, models, progressCallback), 
            executor
        );
    }
    
    private RequestStatusStable pollForImageCompletion(
            String requestId,
            GenerationProgressCallback progressCallback
    ) {
        long startTime = System.currentTimeMillis();
        long timeoutMs = generationTimeoutSeconds * 1000;
        
        while (true) {
            if (System.currentTimeMillis() - startTime > timeoutMs) {
                throw new HordeException("Generation timed out after " + generationTimeoutSeconds + " seconds");
            }
            
            RequestStatusCheck status = checkImageGeneration(requestId);
            
            if (progressCallback != null) {
                progressCallback.onProgress(
                        status.getWaitTime() != null ? status.getWaitTime() : 0,
                        status.getQueuePosition() != null ? status.getQueuePosition() : 0,
                        status.getProcessing() != null ? status.getProcessing() : 0,
                        status.getFinished() != null ? status.getFinished() : 0
                );
            }
            
            if (status.hasFailed()) {
                throw new HordeException("Generation failed");
            }
            
            if (status.isComplete()) {
                return getImageGenerationStatus(requestId);
            }
            
            try {
                Thread.sleep(pollIntervalMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new HordeException("Generation interrupted", e);
            }
        }
    }
    
    // ==================== Text Generation ====================
    
    /**
     * Submits a text generation request.
     *
     * @param request The generation request
     * @return The async request containing the job ID
     * @throws HordeException if the request fails
     */
    public RequestAsync submitTextGeneration(GenerationInputKobold request) {
        return executeCall(api.generateTextAsync(apiKey, clientAgent, request));
    }
    
    /**
     * Checks the status of a text generation request.
     *
     * @param requestId The request ID
     * @return The status check result
     * @throws HordeException if the request fails
     */
    public RequestStatusCheck checkTextGeneration(String requestId) {
        return executeCall(api.checkTextGeneration(requestId));
    }
    
    /**
     * Gets the full status and results of a text generation request.
     *
     * @param requestId The request ID
     * @return The full status with generated text
     * @throws HordeException if the request fails
     */
    public RequestStatusKobold getTextGenerationStatus(String requestId) {
        return executeCall(api.getTextGenerationStatus(requestId));
    }
    
    /**
     * Cancels a pending text generation request.
     *
     * @param requestId The request ID
     * @return The status after cancellation
     * @throws HordeException if the request fails
     */
    public RequestStatusKobold cancelTextGeneration(String requestId) {
        return executeCall(api.cancelTextGeneration(requestId));
    }
    
    /**
     * Generates text synchronously, polling until completion.
     *
     * @param prompt The prompt for text generation
     * @return The result containing generated text
     * @throws HordeException if the generation fails
     */
    public RequestStatusKobold generateText(String prompt) {
        return generateText(prompt, null, null, null);
    }
    
    /**
     * Generates text synchronously with custom parameters.
     *
     * @param prompt The prompt for text generation
     * @param params Optional generation parameters
     * @param models Optional list of models to use
     * @param progressCallback Optional callback for progress updates
     * @return The result containing generated text
     * @throws HordeException if the generation fails
     */
    public RequestStatusKobold generateText(
            String prompt,
            ModelGenerationInputKobold params,
            List<String> models,
            GenerationProgressCallback progressCallback
    ) {
        GenerationInputKobold request = GenerationInputKobold.builder()
                .prompt(prompt)
                .params(params)
                .models(models)
                .build();
        
        return generateText(request, progressCallback);
    }
    
    /**
     * Generates text synchronously with a full request object.
     *
     * @param request The full generation request
     * @param progressCallback Optional callback for progress updates
     * @return The result containing generated text
     * @throws HordeException if the generation fails
     */
    public RequestStatusKobold generateText(
            GenerationInputKobold request,
            GenerationProgressCallback progressCallback
    ) {
        RequestAsync asyncResponse = submitTextGeneration(request);
        String requestId = asyncResponse.getId();
        
        if (requestId == null) {
            throw new HordeException("No request ID returned: " + asyncResponse.getMessage());
        }
        
        return pollForTextCompletion(requestId, progressCallback);
    }
    
    /**
     * Generates text asynchronously.
     *
     * @param prompt The prompt for text generation
     * @return A CompletableFuture that completes with the result
     */
    public CompletableFuture<RequestStatusKobold> generateTextAsync(String prompt) {
        return generateTextAsync(prompt, null, null, null);
    }
    
    /**
     * Generates text asynchronously with custom parameters.
     *
     * @param prompt The prompt for text generation
     * @param params Optional generation parameters
     * @param models Optional list of models to use
     * @param progressCallback Optional callback for progress updates
     * @return A CompletableFuture that completes with the result
     */
    public CompletableFuture<RequestStatusKobold> generateTextAsync(
            String prompt,
            ModelGenerationInputKobold params,
            List<String> models,
            GenerationProgressCallback progressCallback
    ) {
        return CompletableFuture.supplyAsync(() -> 
            generateText(prompt, params, models, progressCallback), 
            executor
        );
    }
    
    private RequestStatusKobold pollForTextCompletion(
            String requestId,
            GenerationProgressCallback progressCallback
    ) {
        long startTime = System.currentTimeMillis();
        long timeoutMs = generationTimeoutSeconds * 1000;
        
        while (true) {
            if (System.currentTimeMillis() - startTime > timeoutMs) {
                throw new HordeException("Generation timed out after " + generationTimeoutSeconds + " seconds");
            }
            
            RequestStatusCheck status = checkTextGeneration(requestId);
            
            if (progressCallback != null) {
                progressCallback.onProgress(
                        status.getWaitTime() != null ? status.getWaitTime() : 0,
                        status.getQueuePosition() != null ? status.getQueuePosition() : 0,
                        status.getProcessing() != null ? status.getProcessing() : 0,
                        status.getFinished() != null ? status.getFinished() : 0
                );
            }
            
            if (status.hasFailed()) {
                throw new HordeException("Generation failed");
            }
            
            if (status.isComplete()) {
                return getTextGenerationStatus(requestId);
            }
            
            try {
                Thread.sleep(pollIntervalMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new HordeException("Generation interrupted", e);
            }
        }
    }
    
    // ==================== User & Models ====================
    
    /**
     * Gets the details of the authenticated user.
     *
     * @return The user details
     * @throws HordeException if the request fails
     */
    public UserDetails findUser() {
        return executeCall(api.findUser(apiKey, clientAgent));
    }
    
    /**
     * Gets all active models.
     *
     * @return The list of active models
     * @throws HordeException if the request fails
     */
    public List<ActiveModel> getActiveModels() {
        return executeCall(api.getActiveModels());
    }
    
    /**
     * Gets active models filtered by type.
     *
     * @param type The model type ("image" or "text")
     * @return The list of active models
     * @throws HordeException if the request fails
     */
    public List<ActiveModel> getActiveModels(String type) {
        return executeCall(api.getActiveModels(type, null));
    }
    
    /**
     * Gets active models filtered by type and minimum worker count.
     *
     * @param type The model type ("image" or "text")
     * @param minCount The minimum number of workers
     * @return The list of active models
     * @throws HordeException if the request fails
     */
    public List<ActiveModel> getActiveModels(String type, Integer minCount) {
        return executeCall(api.getActiveModels(type, minCount));
    }
    
    // ==================== Helper Methods ====================
    
    private <T> T executeCall(Call<T> call) {
        try {
            Response<T> response = call.execute();
            
            if (!response.isSuccessful()) {
                String errorBody = null;
                if (response.errorBody() != null) {
                    try {
                        errorBody = response.errorBody().string();
                    } catch (IOException e) {
                        // Ignore
                    }
                }
                throw new HordeException(
                        "API request failed with code " + response.code(),
                        response.code(),
                        errorBody
                );
            }
            
            return response.body();
        } catch (IOException e) {
            throw new HordeException("API request failed", e);
        }
    }
    
    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    
    // ==================== Builder ====================
    
    /**
     * Builder for HordeClient.
     */
    public static class Builder {
        private String baseUrl = DEFAULT_BASE_URL;
        private String apiKey = DEFAULT_API_KEY;
        private String clientAgent = "AiHorde4J:1.0.0:github.com/Paulem79/AiHorde4J";
        private long pollIntervalMs = DEFAULT_POLL_INTERVAL_MS;
        private long generationTimeoutSeconds = DEFAULT_GENERATION_TIMEOUT_SECONDS;
        private boolean enableLogging = false;
        
        /**
         * Sets the base URL for the API.
         *
         * @param baseUrl The base URL
         * @return This builder
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl cannot be null");
            if (!this.baseUrl.endsWith("/")) {
                this.baseUrl += "/";
            }
            return this;
        }
        
        /**
         * Sets the API key for authentication.
         *
         * @param apiKey The API key
         * @return This builder
         */
        public Builder apiKey(String apiKey) {
            this.apiKey = Objects.requireNonNull(apiKey, "apiKey cannot be null");
            return this;
        }
        
        /**
         * Sets the client agent header.
         *
         * @param clientAgent The client agent string (format: App:Version:Contact)
         * @return This builder
         */
        public Builder clientAgent(String clientAgent) {
            this.clientAgent = Objects.requireNonNull(clientAgent, "clientAgent cannot be null");
            return this;
        }
        
        /**
         * Sets the polling interval for checking generation status.
         *
         * @param pollIntervalMs The polling interval in milliseconds
         * @return This builder
         */
        public Builder pollIntervalMs(long pollIntervalMs) {
            if (pollIntervalMs < 1000) {
                throw new IllegalArgumentException("pollIntervalMs must be at least 1000ms");
            }
            this.pollIntervalMs = pollIntervalMs;
            return this;
        }
        
        /**
         * Sets the timeout for generation requests.
         *
         * @param timeoutSeconds The timeout in seconds
         * @return This builder
         */
        public Builder generationTimeoutSeconds(long timeoutSeconds) {
            if (timeoutSeconds < 1) {
                throw new IllegalArgumentException("generationTimeoutSeconds must be at least 1");
            }
            this.generationTimeoutSeconds = timeoutSeconds;
            return this;
        }
        
        /**
         * Enables HTTP logging for debugging.
         *
         * @param enable Whether to enable logging
         * @return This builder
         */
        public Builder enableLogging(boolean enable) {
            this.enableLogging = enable;
            return this;
        }
        
        /**
         * Builds the HordeClient instance.
         *
         * @return A new HordeClient
         */
        public HordeClient build() {
            return new HordeClient(this);
        }
    }
}
