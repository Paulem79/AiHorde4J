package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Input for creating a team.
 */
public class CreateTeamInput {
    @SerializedName("name")
    private String name;

    @SerializedName("info")
    private String info;

    public CreateTeamInput() {}

    public CreateTeamInput(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public CreateTeamInput setName(String name) { this.name = name; return this; }

    public String getInfo() { return info; }
    public CreateTeamInput setInfo(String info) { this.info = info; return this; }
}
