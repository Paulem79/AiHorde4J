package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Status of an interrogation request.
 */
public record InterrogationStatus(
        @SerializedName("state") String state,
        @SerializedName("forms") List<InterrogationFormStatus> forms
) {}
