package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * User amount records.
 */
public record UserAmountRecords(
        @SerializedName("image") Integer image,
        @SerializedName("text") Integer text,
        @SerializedName("interrogation") Integer interrogation
) {}
