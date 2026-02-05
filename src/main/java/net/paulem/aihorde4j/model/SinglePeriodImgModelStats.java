package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Statistics for image models in a period.
 */
public record SinglePeriodImgModelStats(
        @SerializedName("additionalProperties") Map<String, Integer> models
) {}
