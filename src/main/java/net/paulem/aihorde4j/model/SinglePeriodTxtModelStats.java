package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Statistics for text models in a period.
 */
public record SinglePeriodTxtModelStats(
        @SerializedName("additionalProperties") Map<String, Integer> models
) {}
