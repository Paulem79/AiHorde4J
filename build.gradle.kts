plugins {
    id("java-library")
    id("maven-publish")
}

group = "net.paulem"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
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
                        name.set("GPL-3.0")
                        url.set("https://www.gnu.org/licenses/gpl-3.0.html")
                    }
                }

                developers {
                    developer {
                        id.set("paulem79")
                        name.set("Paulem")
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
            name = "paulem"
            url = uri("https://maven.paulem.net")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
    }
}
