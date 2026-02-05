package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * A completed stable diffusion generation.
 */
public record GenerationStable(
        @SerializedName("worker_id") String workerId,
        @SerializedName("worker_name") String workerName,
        @SerializedName("model") String model,
        @SerializedName("state") String state,
        @SerializedName("img") String img,
        @SerializedName("seed") String seed,
        @SerializedName("id") String id,
        @SerializedName("censored") Boolean censored,
        @SerializedName("gen_metadata") List<GenerationMetadataStable> genMetadata
) {}
