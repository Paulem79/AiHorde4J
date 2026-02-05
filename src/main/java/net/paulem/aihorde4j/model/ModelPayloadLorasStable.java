package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * LoRA configuration for stable diffusion.
 */
public record ModelPayloadLorasStable(
        @SerializedName("name") String name,
        @SerializedName("model") Double model,
        @SerializedName("clip") Double clip,
        @SerializedName("inject_trigger") String injectTrigger,
        @SerializedName("is_version") Boolean isVersion
) {}
