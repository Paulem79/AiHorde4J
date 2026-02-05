package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Metadata about a stable diffusion generation.
 */
public record GenerationMetadataStable(
        @SerializedName("type") String type,
        @SerializedName("value") String value,
        @SerializedName("ref") String ref
) {}
