package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response from modifying a worker.
 */
public record ModifyWorker(
        @SerializedName("maintenance") Boolean maintenance,
        @SerializedName("paused") Boolean paused,
        @SerializedName("info") String info,
        @SerializedName("name") String name,
        @SerializedName("team") String team
) {}
