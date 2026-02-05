package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Metadata about a text generation.
 */
public record GenerationMetadataKobold(
        @SerializedName("type") String type,
        @SerializedName("value") String value,
        @SerializedName("ref") String ref
) {}
