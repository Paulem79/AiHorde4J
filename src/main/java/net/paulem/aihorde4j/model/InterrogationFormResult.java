package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Result of an interrogation form.
 */
public record InterrogationFormResult(
        @SerializedName("caption") String caption,
        @SerializedName("nsfw") Boolean nsfw,
        @SerializedName("additionalProperties") Map<String, Object> additionalProperties
) {}
