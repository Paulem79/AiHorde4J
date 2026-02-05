package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Horde modes information.
 */
public record HordeModes(
        @SerializedName("maintenance_mode") Boolean maintenanceMode,
        @SerializedName("invite_only_mode") Boolean inviteOnlyMode,
        @SerializedName("raid_mode") Boolean raidMode
) {}
