package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * User thing records.
 */
public record UserThingRecords(
        @SerializedName("megapixelsteps") Double megapixelsteps,
        @SerializedName("tokens") Double tokens
) {}
