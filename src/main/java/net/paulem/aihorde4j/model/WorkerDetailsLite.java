package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Lite information about a worker.
 */
public record WorkerDetailsLite(
        @SerializedName("type") String type,
        @SerializedName("name") String name,
        @SerializedName("id") String id,
        @SerializedName("online") Boolean online
) {}
