package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Input for modifying a team.
 */
public class ModifyTeamInput {
    @SerializedName("name")
    private String name;

    @SerializedName("info")
    private String info;

    public ModifyTeamInput() {}

    public String getName() { return name; }
    public ModifyTeamInput setName(String name) { this.name = name; return this; }

    public String getInfo() { return info; }
    public ModifyTeamInput setInfo(String info) { this.info = info; return this; }
}
