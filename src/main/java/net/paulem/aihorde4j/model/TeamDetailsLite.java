package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Lite information about a team.
 */
public record TeamDetailsLite(
        @SerializedName("name") String name,
        @SerializedName("id") String id
) {}
