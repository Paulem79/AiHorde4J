package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request status check response.
 */
public record RequestStatusCheck(
        @SerializedName("finished") Integer finished,
        @SerializedName("processing") Integer processing,
        @SerializedName("restarted") Integer restarted,
        @SerializedName("waiting") Integer waiting,
        @SerializedName("done") Boolean done,
        @SerializedName("faulted") Boolean faulted,
        @SerializedName("wait_time") Integer waitTime,
        @SerializedName("queue_position") Integer queuePosition,
        @SerializedName("kudos") Double kudos,
        @SerializedName("is_possible") Boolean isPossible
) {}
