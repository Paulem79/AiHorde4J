package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Total image statistics.
 */
public record StatsImgTotals(
        @SerializedName("minute") SinglePeriodImgStat minute,
        @SerializedName("hour") SinglePeriodImgStat hour,
        @SerializedName("day") SinglePeriodImgStat day,
        @SerializedName("month") SinglePeriodImgStat month,
        @SerializedName("total") SinglePeriodImgStat total
) {}
