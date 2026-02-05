package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Detailed information about a team.
 */
public record TeamDetails(
        @SerializedName("name") String name,
        @SerializedName("id") String id,
        @SerializedName("info") String info,
        @SerializedName("requests_fulfilled") Integer requestsFulfilled,
        @SerializedName("kudos") Double kudos,
        @SerializedName("uptime") Integer uptime,
        @SerializedName("creator") String creator,
        @SerializedName("worker_count") Integer workerCount,
        @SerializedName("workers") List<WorkerDetailsLite> workers,
        @SerializedName("models") List<ActiveModelLite> models
) {}
