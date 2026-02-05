package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * A completed text generation.
 */
public record GenerationKobold(
        @SerializedName("worker_id") String workerId,
        @SerializedName("worker_name") String workerName,
        @SerializedName("model") String model,
        @SerializedName("state") String state,
        @SerializedName("text") String text,
        @SerializedName("seed") Integer seed,
        @SerializedName("gen_metadata") List<GenerationMetadataKobold> genMetadata
) {}
