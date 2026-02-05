package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response from modifying a team.
 */
public record ModifyTeam(
        @SerializedName("id") String id,
        @SerializedName("name") String name,
        @SerializedName("info") String info
) {}
