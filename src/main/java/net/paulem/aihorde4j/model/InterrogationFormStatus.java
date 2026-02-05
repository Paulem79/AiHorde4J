package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Status of a single interrogation form.
 */
public record InterrogationFormStatus(
        @SerializedName("form") String form,
        @SerializedName("state") String state,
        @SerializedName("result") InterrogationFormResult result
) {}
