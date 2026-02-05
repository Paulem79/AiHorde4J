package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response from deleting a worker.
 */
public record DeletedWorker(
        @SerializedName("deleted_id") String deletedId,
        @SerializedName("deleted_name") String deletedName
) {}
