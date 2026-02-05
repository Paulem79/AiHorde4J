package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Contribution details for a user.
 */
public record ContributionsDetails(
        @SerializedName("megapixelsteps") Double megapixelsteps,
        @SerializedName("fulfillments") Integer fulfillments
) {}
