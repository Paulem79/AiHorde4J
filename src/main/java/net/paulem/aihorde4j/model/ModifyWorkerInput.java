package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Input for modifying a worker.
 */
public class ModifyWorkerInput {
    @SerializedName("maintenance")
    private Boolean maintenance;

    @SerializedName("maintenance_msg")
    private String maintenanceMsg;

    @SerializedName("paused")
    private Boolean paused;

    @SerializedName("info")
    private String info;

    @SerializedName("name")
    private String name;

    @SerializedName("team")
    private String team;

    public ModifyWorkerInput() {}

    public Boolean getMaintenance() { return maintenance; }
    public ModifyWorkerInput setMaintenance(Boolean maintenance) { this.maintenance = maintenance; return this; }

    public String getMaintenanceMsg() { return maintenanceMsg; }
    public ModifyWorkerInput setMaintenanceMsg(String maintenanceMsg) { this.maintenanceMsg = maintenanceMsg; return this; }

    public Boolean getPaused() { return paused; }
    public ModifyWorkerInput setPaused(Boolean paused) { this.paused = paused; return this; }

    public String getInfo() { return info; }
    public ModifyWorkerInput setInfo(String info) { this.info = info; return this; }

    public String getName() { return name; }
    public ModifyWorkerInput setName(String name) { this.name = name; return this; }

    public String getTeam() { return team; }
    public ModifyWorkerInput setTeam(String team) { this.team = team; return this; }
}
