package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response from modifying a user.
 */
public record ModifyUser(
        @SerializedName("new_kudos") Double newKudos,
        @SerializedName("concurrency") Integer concurrency,
        @SerializedName("usage_multiplier") Double usageMultiplier,
        @SerializedName("worker_invited") Integer workerInvited,
        @SerializedName("moderator") Boolean moderator,
        @SerializedName("public_workers") Boolean publicWorkers,
        @SerializedName("username") String username,
        @SerializedName("monthly_kudos") Integer monthlyKudos,
        @SerializedName("trusted") Boolean trusted
) {}
