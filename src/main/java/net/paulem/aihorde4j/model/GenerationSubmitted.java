package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response from generation submit.
 */
public record GenerationSubmitted(
        @SerializedName("reward") Double reward
) {}
