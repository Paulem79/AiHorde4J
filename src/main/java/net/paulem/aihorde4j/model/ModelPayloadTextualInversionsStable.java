package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Textual inversion configuration for stable diffusion.
 */
public record ModelPayloadTextualInversionsStable(
        @SerializedName("name") String name,
        @SerializedName("inject_ti") String injectTi,
        @SerializedName("strength") Double strength
) {}
