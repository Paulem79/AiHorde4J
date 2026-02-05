package net.paulem.aihorde4j.api;

import net.paulem.aihorde4j.dto.request.GenerationInputKobold;
import net.paulem.aihorde4j.dto.request.GenerationInputStable;
import net.paulem.aihorde4j.dto.response.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Retrofit interface for the AI Horde API v2.
 */
public interface HordeApi {
    
    // ==================== Image Generation ====================
    
    /**
     * Initiates an asynchronous image generation request.
     *
     * @param apiKey The API key for authentication
     * @param clientAgent The client agent header
     * @param request The generation request parameters
     * @return A call that returns the async request ID
     */
    @POST("/v2/generate/async")
    Call<RequestAsync> generateImageAsync(
            @Header("apikey") String apiKey,
            @Header("Client-Agent") String clientAgent,
            @Body GenerationInputStable request
    );
    
    /**
     * Checks the status of an image generation request.
     *
     * @param id The request UUID
     * @return A call that returns the status check
     */
    @GET("/v2/generate/check/{id}")
    Call<RequestStatusCheck> checkImageGeneration(
            @Path("id") String id
    );
    
    /**
     * Gets the full status and results of an image generation request.
     *
     * @param id The request UUID
     * @return A call that returns the full status with generated images
     */
    @GET("/v2/generate/status/{id}")
    Call<RequestStatusStable> getImageGenerationStatus(
            @Path("id") String id
    );
    
    /**
     * Cancels a pending image generation request.
     *
     * @param id The request UUID
     * @return A call that returns the status
     */
    @DELETE("/v2/generate/status/{id}")
    Call<RequestStatusStable> cancelImageGeneration(
            @Path("id") String id
    );
    
    // ==================== Text Generation ====================
    
    /**
     * Initiates an asynchronous text generation request.
     *
     * @param apiKey The API key for authentication
     * @param clientAgent The client agent header
     * @param request The generation request parameters
     * @return A call that returns the async request ID
     */
    @POST("/v2/generate/text/async")
    Call<RequestAsync> generateTextAsync(
            @Header("apikey") String apiKey,
            @Header("Client-Agent") String clientAgent,
            @Body GenerationInputKobold request
    );
    
    /**
     * Checks the status of a text generation request.
     *
     * @param id The request UUID
     * @return A call that returns the status check
     */
    @GET("/v2/generate/text/check/{id}")
    Call<RequestStatusCheck> checkTextGeneration(
            @Path("id") String id
    );
    
    /**
     * Gets the full status and results of a text generation request.
     *
     * @param id The request UUID
     * @return A call that returns the full status with generated text
     */
    @GET("/v2/generate/text/status/{id}")
    Call<RequestStatusKobold> getTextGenerationStatus(
            @Path("id") String id
    );
    
    /**
     * Cancels a pending text generation request.
     *
     * @param id The request UUID
     * @return A call that returns the status
     */
    @DELETE("/v2/generate/text/status/{id}")
    Call<RequestStatusKobold> cancelTextGeneration(
            @Path("id") String id
    );
    
    // ==================== User Information ====================
    
    /**
     * Gets the details of the authenticated user.
     *
     * @param apiKey The API key for authentication
     * @param clientAgent The client agent header
     * @return A call that returns user details
     */
    @GET("/v2/find_user")
    Call<UserDetails> findUser(
            @Header("apikey") String apiKey,
            @Header("Client-Agent") String clientAgent
    );
    
    // ==================== Models ====================
    
    /**
     * Gets the list of active models.
     *
     * @param type Filter by model type (image or text)
     * @param minCount Minimum number of workers
     * @return A call that returns the list of active models
     */
    @GET("/v2/status/models")
    Call<List<ActiveModel>> getActiveModels(
            @Query("type") String type,
            @Query("min_count") Integer minCount
    );
    
    /**
     * Gets all active models without filters.
     *
     * @return A call that returns the list of active models
     */
    @GET("/v2/status/models")
    Call<List<ActiveModel>> getActiveModels();
}
