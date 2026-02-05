package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Usage details for a user.
 */
public record UsageDetails(
        @SerializedName("megapixelsteps") Double megapixelsteps,
        @SerializedName("requests") Integer requests
) {}
