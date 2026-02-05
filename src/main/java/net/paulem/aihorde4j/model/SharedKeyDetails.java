package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Shared key details.
 */
public record SharedKeyDetails(
        @SerializedName("id") String id,
        @SerializedName("username") String username,
        @SerializedName("name") String name,
        @SerializedName("kudos") Double kudos,
        @SerializedName("expiry") String expiry,
        @SerializedName("utilized") Integer utilized,
        @SerializedName("max_image_pixels") Integer maxImagePixels,
        @SerializedName("max_image_steps") Integer maxImageSteps,
        @SerializedName("max_text_tokens") Integer maxTextTokens
) {}
