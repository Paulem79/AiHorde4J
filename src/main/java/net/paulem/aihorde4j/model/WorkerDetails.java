package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Detailed information about a worker.
 */
public record WorkerDetails(
        @SerializedName("type") String type,
        @SerializedName("name") String name,
        @SerializedName("id") String id,
        @SerializedName("online") Boolean online,
        @SerializedName("requests_fulfilled") Integer requestsFulfilled,
        @SerializedName("kudos_rewards") Double kudosRewards,
        @SerializedName("kudos_details") WorkerKudosDetails kudosDetails,
        @SerializedName("performance") String performance,
        @SerializedName("threads") Integer threads,
        @SerializedName("uptime") Integer uptime,
        @SerializedName("maintenance_mode") Boolean maintenanceMode,
        @SerializedName("paused") Boolean paused,
        @SerializedName("info") String info,
        @SerializedName("nsfw") Boolean nsfw,
        @SerializedName("owner") String owner,
        @SerializedName("ipaddr") String ipaddr,
        @SerializedName("trusted") Boolean trusted,
        @SerializedName("flagged") Boolean flagged,
        @SerializedName("suspicious") Integer suspicious,
        @SerializedName("uncompleted_jobs") Integer uncompletedJobs,
        @SerializedName("models") List<String> models,
        @SerializedName("forms") List<String> forms,
        @SerializedName("team") TeamDetailsLite team,
        @SerializedName("contact") String contact,
        @SerializedName("bridge_agent") String bridgeAgent,
        @SerializedName("max_pixels") Integer maxPixels,
        @SerializedName("megapixelsteps_generated") Double megapixelstepsGenerated,
        @SerializedName("img2img") Boolean img2img,
        @SerializedName("painting") Boolean painting,
        @SerializedName("post-processing") Boolean postProcessing,
        @SerializedName("lora") Boolean lora,
        @SerializedName("max_length") Integer maxLength,
        @SerializedName("max_context_length") Integer maxContextLength,
        @SerializedName("tokens_generated") Double tokensGenerated
) {}
