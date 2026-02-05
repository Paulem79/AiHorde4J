package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Form type for image interrogation.
 */
public record ModelInterrogationFormStable(
        @SerializedName("name") String name
) {}
