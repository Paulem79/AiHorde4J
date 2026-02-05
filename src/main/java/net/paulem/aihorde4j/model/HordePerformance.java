package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Horde performance information.
 */
public record HordePerformance(
        @SerializedName("queued_requests") Integer queuedRequests,
        @SerializedName("queued_text_requests") Integer queuedTextRequests,
        @SerializedName("worker_count") Integer workerCount,
        @SerializedName("text_worker_count") Integer textWorkerCount,
        @SerializedName("thread_count") Integer threadCount,
        @SerializedName("text_thread_count") Integer textThreadCount,
        @SerializedName("queued_megapixelsteps") Double queuedMegapixelsteps,
        @SerializedName("past_minute_megapixelsteps") Double pastMinuteMegapixelsteps,
        @SerializedName("queued_forms") Double queuedForms,
        @SerializedName("interrogator_count") Integer interrogatorCount,
        @SerializedName("interrogator_thread_count") Integer interrogatorThreadCount,
        @SerializedName("queued_tokens") Double queuedTokens,
        @SerializedName("past_minute_tokens") Double pastMinuteTokens
) {}
