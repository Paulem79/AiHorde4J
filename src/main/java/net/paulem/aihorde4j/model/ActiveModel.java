package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Active model information.
 */
public record ActiveModel(
        @SerializedName("name") String name,
        @SerializedName("count") Integer count,
        @SerializedName("performance") Double performance,
        @SerializedName("queued") Double queued,
        @SerializedName("jobs") Double jobs,
        @SerializedName("eta") Integer eta,
        @SerializedName("type") String type
) {}
