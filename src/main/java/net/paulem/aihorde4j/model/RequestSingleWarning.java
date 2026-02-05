package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * A single warning from the API.
 */
public record RequestSingleWarning(
        @SerializedName("code") String code,
        @SerializedName("message") String message
) {}
