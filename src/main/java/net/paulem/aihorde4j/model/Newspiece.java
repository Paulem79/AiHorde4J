package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * A piece of news.
 */
public record Newspiece(
        @SerializedName("date_published") String datePublished,
        @SerializedName("newspiece") String newspiece,
        @SerializedName("importance") String importance
) {}
