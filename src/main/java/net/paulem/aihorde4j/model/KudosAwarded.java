package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response from kudos award.
 */
public record KudosAwarded(
        @SerializedName("awarded") Double awarded
) {}
