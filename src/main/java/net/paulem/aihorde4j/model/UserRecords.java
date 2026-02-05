package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * User records.
 */
public record UserRecords(
        @SerializedName("usage") UserThingRecords usage,
        @SerializedName("contribution") UserThingRecords contribution,
        @SerializedName("fulfillment") UserAmountRecords fulfillment,
        @SerializedName("request") UserAmountRecords request
) {}
