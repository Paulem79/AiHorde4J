package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Text statistics for a period.
 */
public record SinglePeriodTxtStat(
        @SerializedName("requests") Integer requests,
        @SerializedName("tokens") Integer tokens
) {}
