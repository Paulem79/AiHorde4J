package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Input for creating a shared key.
 */
public class SharedKeyInput {
    @SerializedName("kudos")
    private Double kudos;

    @SerializedName("expiry")
    private Integer expiry;

    @SerializedName("name")
    private String name;

    @SerializedName("max_image_pixels")
    private Integer maxImagePixels;

    @SerializedName("max_image_steps")
    private Integer maxImageSteps;

    @SerializedName("max_text_tokens")
    private Integer maxTextTokens;

    public SharedKeyInput() {}

    public Double getKudos() { return kudos; }
    public SharedKeyInput setKudos(Double kudos) { this.kudos = kudos; return this; }

    public Integer getExpiry() { return expiry; }
    public SharedKeyInput setExpiry(Integer expiry) { this.expiry = expiry; return this; }

    public String getName() { return name; }
    public SharedKeyInput setName(String name) { this.name = name; return this; }

    public Integer getMaxImagePixels() { return maxImagePixels; }
    public SharedKeyInput setMaxImagePixels(Integer maxImagePixels) { this.maxImagePixels = maxImagePixels; return this; }

    public Integer getMaxImageSteps() { return maxImageSteps; }
    public SharedKeyInput setMaxImageSteps(Integer maxImageSteps) { this.maxImageSteps = maxImageSteps; return this; }

    public Integer getMaxTextTokens() { return maxTextTokens; }
    public SharedKeyInput setMaxTextTokens(Integer maxTextTokens) { this.maxTextTokens = maxTextTokens; return this; }
}
