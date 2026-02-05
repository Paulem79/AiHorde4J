package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Error response from the API.
 */
public record RequestError(
        @SerializedName("message") String message,
        @SerializedName("rc") String errorCode
) {}
