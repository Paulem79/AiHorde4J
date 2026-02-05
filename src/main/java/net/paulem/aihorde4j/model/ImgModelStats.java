package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Statistics for image models.
 */
public record ImgModelStats(
        @SerializedName("day") SinglePeriodImgModelStats day,
        @SerializedName("month") SinglePeriodImgModelStats month,
        @SerializedName("total") SinglePeriodImgModelStats total
) {}
