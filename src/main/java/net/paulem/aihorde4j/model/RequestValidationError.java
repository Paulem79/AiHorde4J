package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Validation error response from the API.
 */
public record RequestValidationError(
        @SerializedName("message") String message,
        @SerializedName("rc") String errorCode,
        @SerializedName("errors") Map<String, String> errors
) {}
