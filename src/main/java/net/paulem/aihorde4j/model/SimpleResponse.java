package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Simple response from the API.
 */
public record SimpleResponse(
        @SerializedName("message") String message
) {}
