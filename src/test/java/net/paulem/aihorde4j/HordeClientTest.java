package net.paulem.aihorde4j;

import net.paulem.aihorde4j.client.HordeClient;
import net.paulem.aihorde4j.dto.params.ModelGenerationInputStable;
import net.paulem.aihorde4j.dto.request.GenerationInputStable;
import net.paulem.aihorde4j.dto.response.*;
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
    
    private HordeClient client;

    @BeforeEach
    void setUp() throws IOException {
        client = HordeClient.builder()
                .baseUrl("https://stablehorde.net/api")
                .apiKey("0000000000")
                .clientAgent("AiHorde4J-Test:1.0:test@example.com")
                .pollIntervalMs(2000)
                .generationTimeoutSeconds(120)
                .build();
    }
    
    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }
    
    @Test
    void testSubmitImageGeneration() throws Exception {
        GenerationInputStable request = GenerationInputStable.builder()
                .prompt("A sleek cat")
                .params(ModelGenerationInputStable.builder()
                        .width(512)
                        .height(512)
                        .steps(10)
                        .cfgScale(7.5f)
                        .build())
                .models(List.of("stable_diffusion"))
                .build();
        
        RequestAsync response = client.submitImageGeneration(request);
        
        assertNotNull(response);
        assertNotNull(response.getId());
    }
    
    @Test
    void testCheckImageGeneration() throws Exception {
        GenerationInputStable request = GenerationInputStable.builder()
                .prompt("Blue sky")
                .params(ModelGenerationInputStable.builder()
                        .width(512)
                        .height(512)
                        .steps(5)
                        .build())
                .models(List.of("stable_diffusion"))
                .build();

        RequestAsync submitResponse = client.submitImageGeneration(request);
        String uuid = submitResponse.getId();
        assertNotNull(uuid);

        RequestStatusStable response = client.getImageGenerationStatus(uuid);

        assertNotNull(response);
        assertTrue(response.getWaiting() >= 0);
    }
    
    @Test
    void testGetImageGenerationStatus() throws Exception {
        GenerationInputStable request = GenerationInputStable.builder()
                .prompt("Green forest")
                .params(ModelGenerationInputStable.builder()
                        .width(512)
                        .height(512)
                        .steps(5)
                        .build())
                .models(List.of("stable_diffusion"))
                .build();

        RequestAsync submitResponse = client.submitImageGeneration(request);
        String uuid = submitResponse.getId();

        RequestStatusStable response = client.getImageGenerationStatus(uuid);

        assertNotNull(response);
    }
    
    @Test
    void testFindUser() throws Exception {
        UserDetails response = client.findUser();
        
        assertNotNull(response);
        assertNotNull(response.getUsername());
    }
    
    @Test
    void testGetActiveModels() throws Exception {
        List<ActiveModel> response = client.getActiveModels();
        
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }
    
    @Test
    void testGenerateImageWithPolling() throws Exception {
        RequestStatusStable response = client.generateImage(
                "A robot painting",
                ModelGenerationInputStable.builder()
                        .width(512)
                        .height(512)
                        .steps(10)
                        .build(),
                List.of("stable_diffusion"),
                (waitTime, queuePosition, processing, finished) -> {
                    System.out.println("Wait: " + waitTime + ", Queue: " + queuePosition);
                }
        );
        
        assertNotNull(response);
        assertTrue(response.isComplete());
        assertNotNull(response.getGenerations());
        assertFalse(response.getGenerations().isEmpty());
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
