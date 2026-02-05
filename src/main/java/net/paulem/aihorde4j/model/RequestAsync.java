package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Response from async generation request.
 */
public record RequestAsync(
        @SerializedName("id") String id,
        @SerializedName("kudos") Double kudos,
        @SerializedName("message") String message,
        @SerializedName("warnings") List<RequestSingleWarning> warnings
) {}
