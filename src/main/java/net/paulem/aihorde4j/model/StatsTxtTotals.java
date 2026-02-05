package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Total text statistics.
 */
public record StatsTxtTotals(
        @SerializedName("minute") SinglePeriodTxtStat minute,
        @SerializedName("hour") SinglePeriodTxtStat hour,
        @SerializedName("day") SinglePeriodTxtStat day,
        @SerializedName("month") SinglePeriodTxtStat month,
        @SerializedName("total") SinglePeriodTxtStat total
) {}
