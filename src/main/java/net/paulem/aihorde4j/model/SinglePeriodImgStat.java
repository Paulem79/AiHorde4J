package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Image statistics for a period.
 */
public record SinglePeriodImgStat(
        @SerializedName("images") Integer images,
        @SerializedName("ps") Integer ps
) {}
