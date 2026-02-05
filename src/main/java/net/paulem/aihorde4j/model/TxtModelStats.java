package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Statistics for text models.
 */
public record TxtModelStats(
        @SerializedName("day") SinglePeriodTxtModelStats day,
        @SerializedName("month") SinglePeriodTxtModelStats month,
        @SerializedName("total") SinglePeriodTxtModelStats total
) {}
