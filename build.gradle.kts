plugins {
    java
    `java-library`
    `maven-publish`
}

group = "io.github.aihorde4j"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    // Retrofit for HTTP requests
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    
    // OkHttp for logging
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    
    // Jackson for JSON serialization
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.16.1")
    
    // Lombok for reducing boilerplate (optional)
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    
    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testImplementation("org.mockito:mockito-core:5.8.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.javadoc {
    options {
        (this as StandardJavadocDocletOptions).apply {
            encoding = "UTF-8"
            charSet = "UTF-8"
            addBooleanOption("Xdoclint:none", true)
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            
            pom {
                name.set("AiHorde4J")
                description.set("A Java wrapper for the AI Horde API")
                url.set("https://github.com/Paulem79/AiHorde4J")
                
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                
                developers {
                    developer {
                        id.set("Paulem79")
                        name.set("Paulem79")
                        url.set("https://github.com/Paulem79")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/Paulem79/AiHorde4J.git")
                    developerConnection.set("scm:git:ssh://github.com/Paulem79/AiHorde4J.git")
                    url.set("https://github.com/Paulem79/AiHorde4J")
                }
            }
        }
    }

    repositories {
        maven {
            name = "paulem-releases"
            url = uri("https://maven.paulem.net/releases")

            credentials {
                username = findProperty("PAULEM_MAVEN_USER") as? String ?: System.getenv("PAULEM_MAVEN_USER")
                password = findProperty("PAULEM_MAVEN_PASSWORD") as? String ?: System.getenv("PAULEM_MAVEN_PASSWORD")
            }
        }
    }
}
