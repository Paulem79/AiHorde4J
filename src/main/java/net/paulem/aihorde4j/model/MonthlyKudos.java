package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Monthly kudos information.
 */
public record MonthlyKudos(
        @SerializedName("amount") Integer amount,
        @SerializedName("last_received") String lastReceived
) {}
