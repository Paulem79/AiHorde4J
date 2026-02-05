# AiHorde4J

A Java wrapper for the [AI Horde](https://aihorde.net/) API, providing easy access to distributed image and text generation services.

## Requirements

- Java 21 or higher
- Gradle 8.5 or higher (for building from source)

## Installation

Add the following to your `build.gradle.kts`:

```kotlin
repositories {
    maven {
        url = uri("https://maven.paulem.net")
    }
}

dependencies {
    implementation("net.paulem:AiHorde4J:1.0.0")
}
```

Or for Gradle (Groovy):

```groovy
repositories {
    maven {
        url 'https://maven.paulem.net'
    }
}

dependencies {
    implementation 'net.paulem:AiHorde4J:1.0.0'
}
```

For Maven:

```xml
<repositories>
    <repository>
        <id>paulem</id>
        <url>https://maven.paulem.net</url>
    </repository>
</repositories>

<dependency>
    <groupId>net.paulem</groupId>
    <artifactId>AiHorde4J</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Basic Usage

```java
import net.paulem.aihorde4j.AiHorde;
import net.paulem.aihorde4j.model.*;

// Create client (use "0000000000" for anonymous access)
AiHorde client = new AiHorde("your-api-key");

// Check if API is online
client.getHeartbeat();

// Get current performance metrics
HordePerformance performance = client.getPerformance();
System.out.println("Queued requests: " + performance.queuedRequests());
```

### Image Generation

```java
import net.paulem.aihorde4j.AiHorde;
import net.paulem.aihorde4j.model.*;
import java.util.List;

AiHorde client = new AiHorde("your-api-key");

// Create generation request
GenerationInputStable input = new GenerationInputStable("A beautiful sunset over mountains")
    .setModels(List.of("stable_diffusion"))
    .setParams(new ModelGenerationInputStable()
        .setWidth(512)
        .setHeight(512)
        .setSteps(30)
        .setSamplerName("k_euler_a"));

// Submit async generation
RequestAsync response = client.generateImageAsync(input);
System.out.println("Request ID: " + response.id());

// Poll for status
RequestStatusStable status;
do {
    Thread.sleep(5000); // Wait 5 seconds between checks
    status = client.getImageGenerationStatus(response.id());
    System.out.println("Status: " + status.done() + " - Finished: " + status.finished());
} while (!status.done());

// Get generated images
for (GenerationStable generation : status.generations()) {
    System.out.println("Image (base64): " + generation.img());
    System.out.println("Seed: " + generation.seed());
}
```

### Text Generation

```java
import net.paulem.aihorde4j.AiHorde;
import net.paulem.aihorde4j.model.*;
import java.util.List;

AiHorde client = new AiHorde("your-api-key");

// Create text generation request
GenerationInputKobold input = new GenerationInputKobold("Write a short poem about nature")
    .setParams(new ModelGenerationInputKobold()
        .setMaxLength(200)
        .setTemperature(0.7));

// Submit async generation
RequestAsync response = client.generateTextAsync(input);

// Poll for status and get results
RequestStatusKobold status;
do {
    Thread.sleep(5000);
    status = client.getTextGenerationStatus(response.id());
} while (!status.done());

for (GenerationKobold generation : status.generations()) {
    System.out.println("Generated text: " + generation.text());
}
```

### User Information

```java
import net.paulem.aihorde4j.AiHorde;
import net.paulem.aihorde4j.model.*;

AiHorde client = new AiHorde("your-api-key");

// Get current user info
UserDetails user = client.findUser();
System.out.println("Username: " + user.username());
System.out.println("Kudos: " + user.kudos());
```

### Available Models

```java
import net.paulem.aihorde4j.AiHorde;
import net.paulem.aihorde4j.model.*;
import java.util.List;

AiHorde client = new AiHorde("your-api-key");

// Get all available models
List<ActiveModel> models = client.getModels();
for (ActiveModel model : models) {
    System.out.println(model.name() + " - Workers: " + model.count());
}

// Get only image models
List<ActiveModel> imageModels = client.getModels("image", null);
```

## API Coverage

This library provides access to the following AI Horde API endpoints:

### Status
- `getHeartbeat()` - Check if the API is online
- `getPerformance()` - Get current performance metrics
- `getModes()` / `setModes()` - Get/set operational modes
- `getNews()` - Get latest news
- `getModels()` / `getModel()` - Get available models

### Image Generation
- `generateImageAsync()` - Submit async image generation
- `checkImageGeneration()` - Check generation status (lightweight)
- `getImageGenerationStatus()` - Get status and results
- `cancelImageGeneration()` - Cancel a generation
- `rateGeneration()` - Rate a generated image

### Text Generation
- `generateTextAsync()` - Submit async text generation
- `getTextGenerationStatus()` - Get status and results
- `cancelTextGeneration()` - Cancel a generation

### Interrogation
- `interrogateAsync()` - Submit async image interrogation
- `getInterrogationStatus()` - Get interrogation status
- `cancelInterrogation()` - Cancel an interrogation

### Users
- `findUser()` - Get current user info
- `getUsers()` - List all users
- `getUser()` - Get specific user
- `modifyUser()` - Modify user (admin)

### Workers
- `getWorkers()` - List all workers
- `getWorker()` - Get specific worker
- `modifyWorker()` - Modify worker
- `deleteWorker()` - Delete worker

### Teams
- `getTeams()` - List all teams
- `createTeam()` - Create a team
- `getTeam()` - Get specific team
- `modifyTeam()` - Modify team
- `deleteTeam()` - Delete team

### Kudos
- `transferKudos()` - Transfer kudos to another user
- `awardKudos()` - Award kudos (admin)

### Shared Keys
- `createSharedKey()` - Create a shared key
- `getSharedKey()` - Get shared key details
- `modifySharedKey()` - Modify shared key
- `deleteSharedKey()` - Delete shared key

### Stats
- `getImageModelStats()` - Get image model statistics
- `getImageTotals()` - Get total image statistics
- `getTextModelStats()` - Get text model statistics
- `getTextTotals()` - Get total text statistics

### Filters
- `getFilters()` - List all filters
- `getFilter()` - Get specific filter
- `deleteFilter()` - Delete filter

## License

This project is licensed under the GPL-3.0 License - see the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
