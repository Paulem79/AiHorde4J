package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Extra source image for generation.
 */
public record ExtraSourceImage(
        @SerializedName("image") String image,
        @SerializedName("strength") Double strength
) {}
