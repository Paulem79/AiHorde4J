package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Kudos details for a user.
 */
public record UserKudosDetails(
        @SerializedName("accumulated") Double accumulated,
        @SerializedName("gifted") Double gifted,
        @SerializedName("donated") Double donated,
        @SerializedName("admin") Double admin,
        @SerializedName("received") Double received,
        @SerializedName("recurring") Double recurring,
        @SerializedName("awarded") Double awarded
) {}
