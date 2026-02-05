package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Kudos details for a worker.
 */
public record WorkerKudosDetails(
        @SerializedName("generated") Double generated,
        @SerializedName("uptime") Integer uptime
) {}
