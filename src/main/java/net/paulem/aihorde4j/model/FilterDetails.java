package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Filter details.
 */
public record FilterDetails(
        @SerializedName("id") String id,
        @SerializedName("regex") String regex,
        @SerializedName("filter_type") Integer filterType,
        @SerializedName("description") String description,
        @SerializedName("replacement") String replacement,
        @SerializedName("user") String user
) {}
