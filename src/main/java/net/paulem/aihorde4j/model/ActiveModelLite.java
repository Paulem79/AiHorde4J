package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Lite active model information.
 */
public record ActiveModelLite(
        @SerializedName("name") String name,
        @SerializedName("count") Integer count
) {}
