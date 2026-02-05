package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Special payload for stable diffusion.
 */
public record ModelSpecialPayloadStable(
        @SerializedName("special_key") String specialKey
) {}
