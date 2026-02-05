# AiHorde4J

A Java wrapper library for the [AI Horde](https://stablehorde.net/) API (v2). This library provides a simple and type-safe way to interact with the AI Horde distributed computing platform for generating images (Stable Diffusion) and text (LLM/Kobold).

## Features

- **Complete API Coverage**: Support for image generation, text generation, user information, and model listing
- **Async Generation Workflow**: Automatic polling mechanism for async generation requests
- **Thread-Safe**: Designed for concurrent use in multi-threaded applications
- **Builder Pattern**: Fluent API for building requests
- **Progress Callbacks**: Monitor generation progress with callbacks
- **Error Handling**: Comprehensive exception handling with detailed error information

## Requirements

- Java 17 or higher
- Gradle (for building)

## Installation

### Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation("io.github.aihorde4j:AiHorde4J:1.0.0")
}
```

### Gradle (Groovy)

```groovy
dependencies {
    implementation 'io.github.aihorde4j:AiHorde4J:1.0.0'
}
```

## Quick Start

### Create a Client

```java
// With anonymous access (limited functionality)
HordeClient client = HordeClient.createDefault();

// With API key
HordeClient client = HordeClient.withApiKey("your-api-key");

// With full configuration
HordeClient client = HordeClient.builder()
    .apiKey("your-api-key")
    .clientAgent("MyApp:1.0:contact@example.com")
    .pollIntervalMs(5000)
    .generationTimeoutSeconds(600)
    .enableLogging(true)
    .build();
```

### Generate an Image

```java
// Simple generation
RequestStatusStable result = client.generateImage("A beautiful sunset over mountains");

// With parameters
ModelGenerationInputStable params = ModelGenerationInputStable.builder()
    .width(512)
    .height(512)
    .steps(30)
    .cfgScale(7.5f)
    .samplerName("k_euler")
    .build();

RequestStatusStable result = client.generateImage(
    "A beautiful sunset over mountains",
    params,
    List.of("stable_diffusion"),
    (waitTime, queuePos, processing, finished) -> {
        System.out.println("Wait time: " + waitTime + "s, Queue position: " + queuePos);
    }
);

// Access the generated images
for (Generation gen : result.getGenerations()) {
    String imageBase64 = gen.getImg();
    String model = gen.getModel();
    String seed = gen.getSeed();
    // Process the image...
}
```

### Generate Text

```java
// Simple text generation
RequestStatusKobold result = client.generateText("Once upon a time");

// With parameters
ModelGenerationInputKobold params = ModelGenerationInputKobold.builder()
    .maxLength(200)
    .temperature(0.7f)
    .topP(0.9f)
    .build();

RequestStatusKobold result = client.generateText(
    "Once upon a time",
    params,
    List.of("koboldcpp/LLaMA-2-13B-Erebus-v3-GGUF"),
    null
);

// Access the generated text
for (GenerationKobold gen : result.getGenerations()) {
    String text = gen.getText();
    // Process the text...
}
```

### Async Generation

```java
// Async image generation
CompletableFuture<RequestStatusStable> future = client.generateImageAsync("A cyberpunk city");

future.thenAccept(result -> {
    System.out.println("Generated " + result.getGenerations().size() + " images!");
});

// Async text generation
CompletableFuture<RequestStatusKobold> textFuture = client.generateTextAsync("Tell me a story about");
```

### User Information

```java
UserDetails user = client.findUser();
System.out.println("Username: " + user.getUsername());
System.out.println("Kudos: " + user.getKudos());
```

### List Models

```java
// All models
List<ActiveModel> models = client.getActiveModels();

// Image models only
List<ActiveModel> imageModels = client.getActiveModels("image");

// Text models with at least 2 workers
List<ActiveModel> textModels = client.getActiveModels("text", 2);

for (ActiveModel model : models) {
    System.out.println(model.getName() + " - " + model.getCount() + " workers");
}
```

### Low-Level API Access

For more control, you can access the Retrofit API directly:

```java
HordeApi api = client.getApi();

// Submit request manually
Call<RequestAsync> call = api.generateImageAsync(apiKey, clientAgent, request);
Response<RequestAsync> response = call.execute();

// Check status
Call<RequestStatusCheck> checkCall = api.checkImageGeneration(requestId);
```

## API Reference

### HordeClient Methods

#### Image Generation
- `submitImageGeneration(GenerationInputStable request)` - Submit an image generation request
- `checkImageGeneration(String requestId)` - Check the status of a request
- `getImageGenerationStatus(String requestId)` - Get the full status with results
- `cancelImageGeneration(String requestId)` - Cancel a pending request
- `generateImage(...)` - Convenience method with automatic polling
- `generateImageAsync(...)` - Async version of generateImage

#### Text Generation
- `submitTextGeneration(GenerationInputKobold request)` - Submit a text generation request
- `checkTextGeneration(String requestId)` - Check the status of a request
- `getTextGenerationStatus(String requestId)` - Get the full status with results
- `cancelTextGeneration(String requestId)` - Cancel a pending request
- `generateText(...)` - Convenience method with automatic polling
- `generateTextAsync(...)` - Async version of generateText

#### User & Models
- `findUser()` - Get current user details
- `getActiveModels()` - List all active models
- `getActiveModels(String type)` - List models by type
- `getActiveModels(String type, Integer minCount)` - List models with filters

## Building from Source

```bash
# Clone the repository
git clone https://github.com/Paulem79/AiHorde4J.git

# Build the project
./gradlew build

# Run tests
./gradlew test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

