package net.paulem.aihorde4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.paulem.aihorde4j.client.HordeClient;
import net.paulem.aihorde4j.dto.params.ModelGenerationInputStable;
import net.paulem.aihorde4j.dto.request.GenerationInputStable;
import net.paulem.aihorde4j.dto.response.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for HordeClient.
 */
class HordeClientTest {
    
    private MockWebServer mockServer;
    private HordeClient client;
    private ObjectMapper objectMapper;
    
    @BeforeEach
    void setUp() throws IOException {
        mockServer = new MockWebServer();
        mockServer.start();
        
        objectMapper = new ObjectMapper();
        
        client = HordeClient.builder()
                .baseUrl(mockServer.url("/api").toString())
                .apiKey("test-api-key")
                .clientAgent("TestApp:1.0:test@example.com")
                .pollIntervalMs(1000)
                .generationTimeoutSeconds(60)
                .build();
    }
    
    @AfterEach
    void tearDown() throws IOException {
        client.close();
        mockServer.shutdown();
    }
    
    @Test
    void testSubmitImageGeneration() throws Exception {
        // Prepare mock response
        RequestAsync asyncResponse = new RequestAsync();
        asyncResponse.setId("test-uuid-123");
        asyncResponse.setKudos(10.0);
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(asyncResponse))
                .addHeader("Content-Type", "application/json"));
        
        // Make request
        GenerationInputStable request = GenerationInputStable.builder()
                .prompt("A beautiful sunset over mountains")
                .params(ModelGenerationInputStable.builder()
                        .width(512)
                        .height(512)
                        .steps(20)
                        .cfgScale(7.5f)
                        .build())
                .models(List.of("stable_diffusion"))
                .build();
        
        RequestAsync response = client.submitImageGeneration(request);
        
        // Verify response
        assertNotNull(response);
        assertEquals("test-uuid-123", response.getId());
        assertEquals(10.0, response.getKudos());
        
        // Verify request
        RecordedRequest recordedRequest = mockServer.takeRequest();
        assertEquals("POST", recordedRequest.getMethod());
        assertTrue(recordedRequest.getPath().endsWith("/v2/generate/async"));
        assertEquals("test-api-key", recordedRequest.getHeader("apikey"));
        assertEquals("TestApp:1.0:test@example.com", recordedRequest.getHeader("Client-Agent"));
    }
    
    @Test
    void testCheckImageGeneration() throws Exception {
        // Prepare mock response
        RequestStatusCheck statusCheck = new RequestStatusCheck();
        statusCheck.setDone(false);
        statusCheck.setWaiting(1);
        statusCheck.setProcessing(0);
        statusCheck.setFinished(0);
        statusCheck.setWaitTime(30);
        statusCheck.setQueuePosition(5);
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(statusCheck))
                .addHeader("Content-Type", "application/json"));
        
        // Make request
        RequestStatusCheck response = client.checkImageGeneration("test-uuid-123");
        
        // Verify response
        assertNotNull(response);
        assertFalse(response.isComplete());
        assertEquals(1, response.getWaiting());
        assertEquals(30, response.getWaitTime());
        assertEquals(5, response.getQueuePosition());
        
        // Verify request
        RecordedRequest recordedRequest = mockServer.takeRequest();
        assertEquals("GET", recordedRequest.getMethod());
        assertTrue(recordedRequest.getPath().endsWith("/v2/generate/check/test-uuid-123"));
    }
    
    @Test
    void testGetImageGenerationStatus() throws Exception {
        // Prepare mock response
        Generation generation = new Generation();
        generation.setWorkerId("worker-123");
        generation.setWorkerName("TestWorker");
        generation.setModel("stable_diffusion");
        generation.setImg("base64encodedimage...");
        generation.setSeed("12345");
        
        RequestStatusStable status = new RequestStatusStable();
        status.setDone(true);
        status.setFinished(1);
        status.setGenerations(List.of(generation));
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(status))
                .addHeader("Content-Type", "application/json"));
        
        // Make request
        RequestStatusStable response = client.getImageGenerationStatus("test-uuid-123");
        
        // Verify response
        assertNotNull(response);
        assertTrue(response.isComplete());
        assertEquals(1, response.getFinished());
        assertNotNull(response.getGenerations());
        assertEquals(1, response.getGenerations().size());
        assertEquals("TestWorker", response.getGenerations().get(0).getWorkerName());
        
        // Verify request
        RecordedRequest recordedRequest = mockServer.takeRequest();
        assertEquals("GET", recordedRequest.getMethod());
        assertTrue(recordedRequest.getPath().endsWith("/v2/generate/status/test-uuid-123"));
    }
    
    @Test
    void testFindUser() throws Exception {
        // Prepare mock response
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("TestUser");
        userDetails.setId(12345);
        userDetails.setKudos(1000.0);
        userDetails.setTrusted(true);
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(userDetails))
                .addHeader("Content-Type", "application/json"));
        
        // Make request
        UserDetails response = client.findUser();
        
        // Verify response
        assertNotNull(response);
        assertEquals("TestUser", response.getUsername());
        assertEquals(12345, response.getId());
        assertEquals(1000.0, response.getKudos());
        assertTrue(response.getTrusted());
        
        // Verify request
        RecordedRequest recordedRequest = mockServer.takeRequest();
        assertEquals("GET", recordedRequest.getMethod());
        assertTrue(recordedRequest.getPath().endsWith("/v2/find_user"));
        assertEquals("test-api-key", recordedRequest.getHeader("apikey"));
    }
    
    @Test
    void testGetActiveModels() throws Exception {
        // Prepare mock response
        ActiveModel model1 = new ActiveModel();
        model1.setName("stable_diffusion");
        model1.setCount(10);
        model1.setType("image");
        
        ActiveModel model2 = new ActiveModel();
        model2.setName("stable_diffusion_xl");
        model2.setCount(5);
        model2.setType("image");
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(List.of(model1, model2)))
                .addHeader("Content-Type", "application/json"));
        
        // Make request
        List<ActiveModel> response = client.getActiveModels();
        
        // Verify response
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("stable_diffusion", response.get(0).getName());
        assertEquals(10, response.get(0).getCount());
        
        // Verify request
        RecordedRequest recordedRequest = mockServer.takeRequest();
        assertEquals("GET", recordedRequest.getMethod());
        assertTrue(recordedRequest.getPath().endsWith("/v2/status/models"));
    }
    
    @Test
    void testGenerateImageWithPolling() throws Exception {
        // Prepare mock responses for the full generation flow
        
        // 1. Submit response
        RequestAsync asyncResponse = new RequestAsync();
        asyncResponse.setId("poll-test-uuid");
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(asyncResponse))
                .addHeader("Content-Type", "application/json"));
        
        // 2. First check - not done
        RequestStatusCheck statusCheck1 = new RequestStatusCheck();
        statusCheck1.setDone(false);
        statusCheck1.setWaiting(1);
        statusCheck1.setProcessing(0);
        statusCheck1.setWaitTime(10);
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(statusCheck1))
                .addHeader("Content-Type", "application/json"));
        
        // 3. Second check - done
        RequestStatusCheck statusCheck2 = new RequestStatusCheck();
        statusCheck2.setDone(true);
        statusCheck2.setFinished(1);
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(statusCheck2))
                .addHeader("Content-Type", "application/json"));
        
        // 4. Get status response
        Generation generation = new Generation();
        generation.setImg("generatedimage...");
        generation.setSeed("98765");
        
        RequestStatusStable statusFinal = new RequestStatusStable();
        statusFinal.setDone(true);
        statusFinal.setFinished(1);
        statusFinal.setGenerations(List.of(generation));
        
        mockServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(statusFinal))
                .addHeader("Content-Type", "application/json"));
        
        // Make request with progress callback
        final int[] progressCalls = {0};
        RequestStatusStable response = client.generateImage(
                "test prompt",
                null,
                null,
                (waitTime, queuePosition, processing, finished) -> progressCalls[0]++
        );
        
        // Verify response
        assertNotNull(response);
        assertTrue(response.isComplete());
        assertEquals(1, response.getGenerations().size());
        assertEquals("98765", response.getGenerations().get(0).getSeed());
        
        // Verify progress was called
        assertEquals(2, progressCalls[0]); // Called twice (once per check)
    }
    
    @Test
    void testBuilderDefaults() {
        HordeClient defaultClient = HordeClient.createDefault();
        assertNotNull(defaultClient);
        defaultClient.close();
    }
    
    @Test
    void testBuilderWithApiKey() {
        HordeClient keyClient = HordeClient.withApiKey("custom-key");
        assertNotNull(keyClient);
        keyClient.close();
    }
    
    @Test
    void testModelGenerationInputStableBuilder() {
        ModelGenerationInputStable params = ModelGenerationInputStable.builder()
                .samplerName("k_euler")
                .cfgScale(7.5f)
                .width(512)
                .height(512)
                .steps(30)
                .seed("12345")
                .clipSkip(2)
                .karras(true)
                .build();
        
        assertEquals("k_euler", params.getSamplerName());
        assertEquals(7.5f, params.getCfgScale());
        assertEquals(512, params.getWidth());
        assertEquals(512, params.getHeight());
        assertEquals(30, params.getSteps());
        assertEquals("12345", params.getSeed());
        assertEquals(2, params.getClipSkip());
        assertTrue(params.getKarras());
    }
    
    @Test
    void testGenerationInputStableBuilder() {
        GenerationInputStable request = GenerationInputStable.builder()
                .prompt("A test prompt")
                .nsfw(false)
                .censorNsfw(true)
                .trustedWorkers(true)
                .models(List.of("model1", "model2"))
                .r2(true)
                .build();
        
        assertEquals("A test prompt", request.getPrompt());
        assertFalse(request.getNsfw());
        assertTrue(request.getCensorNsfw());
        assertTrue(request.getTrustedWorkers());
        assertEquals(2, request.getModels().size());
        assertTrue(request.getR2());
    }
}
