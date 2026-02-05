package net.paulem.aihorde4j;

import com.google.gson.reflect.TypeToken;
import net.paulem.aihorde4j.client.AiHordeHttpClient;
import net.paulem.aihorde4j.model.*;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main client for the AI Horde API.
 * <p>
 * Example usage:
 * <pre>
 * AiHorde client = new AiHorde("your-api-key");
 * 
 * // Check heartbeat
 * client.getHeartbeat();
 * 
 * // Generate an image
 * GenerationInputStable input = new GenerationInputStable("A beautiful sunset over mountains")
 *     .setModels(List.of("stable_diffusion"))
 *     .setParams(new ModelGenerationInputStable().setWidth(512).setHeight(512));
 * RequestAsync response = client.generateImageAsync(input);
 * 
 * // Check status
 * RequestStatusStable status = client.getImageGenerationStatus(response.id());
 * </pre>
 */
public class AiHorde {
    private final AiHordeHttpClient httpClient;

    /**
     * Create a new AiHorde client with the default base URL.
     *
     * @param apiKey The API key for authentication (use "0000000000" for anonymous access)
     */
    public AiHorde(String apiKey) {
        this.httpClient = new AiHordeHttpClient(apiKey);
    }

    /**
     * Create a new AiHorde client with a custom base URL.
     *
     * @param apiKey  The API key for authentication
     * @param baseUrl The base URL of the AI Horde API
     */
    public AiHorde(String apiKey, String baseUrl) {
        this.httpClient = new AiHordeHttpClient(apiKey, baseUrl);
    }

    /**
     * Create a new AiHorde client with custom settings.
     *
     * @param apiKey      The API key for authentication
     * @param baseUrl     The base URL of the AI Horde API
     * @param clientAgent The client agent string
     */
    public AiHorde(String apiKey, String baseUrl, String clientAgent) {
        this.httpClient = new AiHordeHttpClient(apiKey, baseUrl, clientAgent);
    }

    // ==================== STATUS ENDPOINTS ====================

    /**
     * Check if the API is online.
     */
    public void getHeartbeat() {
        httpClient.get("/v2/status/heartbeat", Void.class);
    }

    /**
     * Get current performance metrics.
     */
    public HordePerformance getPerformance() {
        return httpClient.get("/v2/status/performance", HordePerformance.class);
    }

    /**
     * Get the current operational modes.
     */
    public HordeModes getModes() {
        return httpClient.get("/v2/status/modes", HordeModes.class);
    }

    /**
     * Set the operational modes (admin only).
     */
    public HordeModes setModes(HordeModes modes) {
        return httpClient.put("/v2/status/modes", modes, HordeModes.class);
    }

    /**
     * Get the latest news.
     */
    public List<Newspiece> getNews() {
        Type listType = new TypeToken<List<Newspiece>>(){}.getType();
        return httpClient.get("/v2/status/news", listType);
    }

    /**
     * Get all active models.
     *
     * @param type    Filter by model type ("image" or "text")
     * @param minCount Minimum number of workers required
     */
    public List<ActiveModel> getModels(String type, Integer minCount) {
        Map<String, String> params = new HashMap<>();
        if (type != null) params.put("type", type);
        if (minCount != null) params.put("min_count", minCount.toString());
        Type listType = new TypeToken<List<ActiveModel>>(){}.getType();
        return httpClient.get("/v2/status/models", listType, params);
    }

    /**
     * Get all active models.
     */
    public List<ActiveModel> getModels() {
        return getModels(null, null);
    }

    /**
     * Get details about a specific model.
     */
    public List<ActiveModel> getModel(String modelName) {
        String encoded = URLEncoder.encode(modelName, StandardCharsets.UTF_8);
        Type listType = new TypeToken<List<ActiveModel>>(){}.getType();
        return httpClient.get("/v2/status/models/" + encoded, listType);
    }

    // ==================== IMAGE GENERATION ENDPOINTS ====================

    /**
     * Submit an async image generation request.
     */
    public RequestAsync generateImageAsync(GenerationInputStable input) {
        return httpClient.post("/v2/generate/async", input, RequestAsync.class);
    }

    /**
     * Check the status of an image generation request.
     */
    public RequestStatusCheck checkImageGeneration(String id) {
        return httpClient.get("/v2/generate/check/" + id, RequestStatusCheck.class);
    }

    /**
     * Get the status and results of an image generation request.
     */
    public RequestStatusStable getImageGenerationStatus(String id) {
        return httpClient.get("/v2/generate/status/" + id, RequestStatusStable.class);
    }

    /**
     * Cancel an image generation request.
     */
    public RequestStatusStable cancelImageGeneration(String id) {
        return httpClient.delete("/v2/generate/status/" + id, RequestStatusStable.class);
    }

    /**
     * Rate an image generation.
     */
    public SimpleResponse rateGeneration(String id, AestheticsPayload payload) {
        return httpClient.post("/v2/generate/rate/" + id, payload, SimpleResponse.class);
    }

    // ==================== TEXT GENERATION ENDPOINTS ====================

    /**
     * Submit an async text generation request.
     */
    public RequestAsync generateTextAsync(GenerationInputKobold input) {
        return httpClient.post("/v2/generate/text/async", input, RequestAsync.class);
    }

    /**
     * Get the status and results of a text generation request.
     */
    public RequestStatusKobold getTextGenerationStatus(String id) {
        return httpClient.get("/v2/generate/text/status/" + id, RequestStatusKobold.class);
    }

    /**
     * Cancel a text generation request.
     */
    public RequestStatusKobold cancelTextGeneration(String id) {
        return httpClient.delete("/v2/generate/text/status/" + id, RequestStatusKobold.class);
    }

    // ==================== INTERROGATION ENDPOINTS ====================

    /**
     * Submit an async interrogation request.
     */
    public RequestAsync interrogateAsync(ModelInterrogationInputStable input) {
        return httpClient.post("/v2/interrogate/async", input, RequestAsync.class);
    }

    /**
     * Get the status of an interrogation request.
     */
    public InterrogationStatus getInterrogationStatus(String id) {
        return httpClient.get("/v2/interrogate/status/" + id, InterrogationStatus.class);
    }

    /**
     * Cancel an interrogation request.
     */
    public InterrogationStatus cancelInterrogation(String id) {
        return httpClient.delete("/v2/interrogate/status/" + id, InterrogationStatus.class);
    }

    // ==================== USER ENDPOINTS ====================

    /**
     * Find the current user based on the API key.
     */
    public UserDetails findUser() {
        return httpClient.get("/v2/find_user", UserDetails.class);
    }

    /**
     * Get a list of all users.
     */
    public List<UserDetails> getUsers() {
        Type listType = new TypeToken<List<UserDetails>>(){}.getType();
        return httpClient.get("/v2/users", listType);
    }

    /**
     * Get details about a specific user.
     */
    public UserDetails getUser(String userId) {
        return httpClient.get("/v2/users/" + userId, UserDetails.class);
    }

    /**
     * Modify a user (admin only).
     */
    public ModifyUser modifyUser(String userId, ModifyUserInput input) {
        return httpClient.put("/v2/users/" + userId, input, ModifyUser.class);
    }

    // ==================== WORKER ENDPOINTS ====================

    /**
     * Get a list of all workers.
     */
    public List<WorkerDetails> getWorkers() {
        return getWorkers(null);
    }

    /**
     * Get a list of workers filtered by type.
     *
     * @param type Worker type ("image", "text", or "interrogation")
     */
    public List<WorkerDetails> getWorkers(String type) {
        Map<String, String> params = new HashMap<>();
        if (type != null) params.put("type", type);
        Type listType = new TypeToken<List<WorkerDetails>>(){}.getType();
        return httpClient.get("/v2/workers", listType, params);
    }

    /**
     * Get details about a specific worker.
     */
    public WorkerDetails getWorker(String workerId) {
        return httpClient.get("/v2/workers/" + workerId, WorkerDetails.class);
    }

    /**
     * Modify a worker.
     */
    public ModifyWorker modifyWorker(String workerId, ModifyWorkerInput input) {
        return httpClient.put("/v2/workers/" + workerId, input, ModifyWorker.class);
    }

    /**
     * Delete a worker.
     */
    public DeletedWorker deleteWorker(String workerId) {
        return httpClient.delete("/v2/workers/" + workerId, DeletedWorker.class);
    }

    // ==================== TEAM ENDPOINTS ====================

    /**
     * Get a list of all teams.
     */
    public List<TeamDetails> getTeams() {
        Type listType = new TypeToken<List<TeamDetails>>(){}.getType();
        return httpClient.get("/v2/teams", listType);
    }

    /**
     * Create a new team.
     */
    public CreatedTeam createTeam(CreateTeamInput input) {
        return httpClient.post("/v2/teams", input, CreatedTeam.class);
    }

    /**
     * Get details about a specific team.
     */
    public TeamDetails getTeam(String teamId) {
        return httpClient.get("/v2/teams/" + teamId, TeamDetails.class);
    }

    /**
     * Modify a team.
     */
    public ModifyTeam modifyTeam(String teamId, ModifyTeamInput input) {
        return httpClient.patch("/v2/teams/" + teamId, input, ModifyTeam.class);
    }

    /**
     * Delete a team.
     */
    public DeletedTeam deleteTeam(String teamId) {
        return httpClient.delete("/v2/teams/" + teamId, DeletedTeam.class);
    }

    // ==================== KUDOS ENDPOINTS ====================

    /**
     * Transfer kudos to another user.
     */
    public KudosTransferred transferKudos(KudosTransferInput input) {
        return httpClient.post("/v2/kudos/transfer", input, KudosTransferred.class);
    }

    /**
     * Award kudos to a user (admin only).
     */
    public KudosAwarded awardKudos(KudosAwardInput input) {
        return httpClient.post("/v2/kudos/award", input, KudosAwarded.class);
    }

    // ==================== SHARED KEY ENDPOINTS ====================

    /**
     * Create a shared key.
     */
    public SharedKeyDetails createSharedKey(SharedKeyInput input) {
        return httpClient.put("/v2/sharedkeys", input, SharedKeyDetails.class);
    }

    /**
     * Get details about a shared key.
     */
    public SharedKeyDetails getSharedKey(String sharedKeyId) {
        return httpClient.get("/v2/sharedkeys/" + sharedKeyId, SharedKeyDetails.class);
    }

    /**
     * Modify a shared key.
     */
    public SharedKeyDetails modifySharedKey(String sharedKeyId, SharedKeyInput input) {
        return httpClient.patch("/v2/sharedkeys/" + sharedKeyId, input, SharedKeyDetails.class);
    }

    /**
     * Delete a shared key.
     */
    public SimpleResponse deleteSharedKey(String sharedKeyId) {
        return httpClient.delete("/v2/sharedkeys/" + sharedKeyId, SimpleResponse.class);
    }

    // ==================== STATS ENDPOINTS ====================

    /**
     * Get image model statistics.
     */
    public ImgModelStats getImageModelStats() {
        return httpClient.get("/v2/stats/img/models", ImgModelStats.class);
    }

    /**
     * Get total image statistics.
     */
    public StatsImgTotals getImageTotals() {
        return httpClient.get("/v2/stats/img/totals", StatsImgTotals.class);
    }

    /**
     * Get text model statistics.
     */
    public TxtModelStats getTextModelStats() {
        return httpClient.get("/v2/stats/text/models", TxtModelStats.class);
    }

    /**
     * Get total text statistics.
     */
    public StatsTxtTotals getTextTotals() {
        return httpClient.get("/v2/stats/text/totals", StatsTxtTotals.class);
    }

    // ==================== FILTER ENDPOINTS ====================

    /**
     * Get all filters.
     */
    public List<FilterDetails> getFilters() {
        Type listType = new TypeToken<List<FilterDetails>>(){}.getType();
        return httpClient.get("/v2/filters", listType);
    }

    /**
     * Get a specific filter.
     */
    public FilterDetails getFilter(String filterId) {
        return httpClient.get("/v2/filters/" + filterId, FilterDetails.class);
    }

    /**
     * Delete a filter.
     */
    public SimpleResponse deleteFilter(String filterId) {
        return httpClient.delete("/v2/filters/" + filterId, SimpleResponse.class);
    }

    /**
     * Get the HTTP client for advanced usage.
     */
    public AiHordeHttpClient getHttpClient() {
        return httpClient;
    }
}
