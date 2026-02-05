package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response containing the created team ID.
 */
public record CreatedTeam(
        @SerializedName("id") String id,
        @SerializedName("name") String name
) {}
