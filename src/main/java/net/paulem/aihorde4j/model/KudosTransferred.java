package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response from kudos transfer.
 */
public record KudosTransferred(
        @SerializedName("transferred") Double transferred
) {}
