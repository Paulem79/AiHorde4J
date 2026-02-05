package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Input for modifying a user.
 */
public class ModifyUserInput {
    @SerializedName("kudos")
    private Double kudos;

    @SerializedName("concurrency")
    private Integer concurrency;

    @SerializedName("usage_multiplier")
    private Double usageMultiplier;

    @SerializedName("worker_invited")
    private Integer workerInvited;

    @SerializedName("moderator")
    private Boolean moderator;

    @SerializedName("public_workers")
    private Boolean publicWorkers;

    @SerializedName("monthly_kudos")
    private Integer monthlyKudos;

    @SerializedName("username")
    private String username;

    @SerializedName("trusted")
    private Boolean trusted;

    @SerializedName("flagged")
    private Boolean flagged;

    @SerializedName("customizer")
    private Boolean customizer;

    @SerializedName("vpn")
    private Boolean vpn;

    @SerializedName("service")
    private Boolean service;

    @SerializedName("education")
    private Boolean education;

    @SerializedName("special")
    private Boolean special;

    @SerializedName("filtered")
    private Boolean filtered;

    @SerializedName("reset_suspicion")
    private Boolean resetSuspicion;

    @SerializedName("contact")
    private String contact;

    @SerializedName("admin_comment")
    private String adminComment;

    public ModifyUserInput() {}

    public Double getKudos() { return kudos; }
    public ModifyUserInput setKudos(Double kudos) { this.kudos = kudos; return this; }

    public Integer getConcurrency() { return concurrency; }
    public ModifyUserInput setConcurrency(Integer concurrency) { this.concurrency = concurrency; return this; }

    public Double getUsageMultiplier() { return usageMultiplier; }
    public ModifyUserInput setUsageMultiplier(Double usageMultiplier) { this.usageMultiplier = usageMultiplier; return this; }

    public Integer getWorkerInvited() { return workerInvited; }
    public ModifyUserInput setWorkerInvited(Integer workerInvited) { this.workerInvited = workerInvited; return this; }

    public Boolean getModerator() { return moderator; }
    public ModifyUserInput setModerator(Boolean moderator) { this.moderator = moderator; return this; }

    public Boolean getPublicWorkers() { return publicWorkers; }
    public ModifyUserInput setPublicWorkers(Boolean publicWorkers) { this.publicWorkers = publicWorkers; return this; }

    public Integer getMonthlyKudos() { return monthlyKudos; }
    public ModifyUserInput setMonthlyKudos(Integer monthlyKudos) { this.monthlyKudos = monthlyKudos; return this; }

    public String getUsername() { return username; }
    public ModifyUserInput setUsername(String username) { this.username = username; return this; }

    public Boolean getTrusted() { return trusted; }
    public ModifyUserInput setTrusted(Boolean trusted) { this.trusted = trusted; return this; }

    public Boolean getFlagged() { return flagged; }
    public ModifyUserInput setFlagged(Boolean flagged) { this.flagged = flagged; return this; }

    public Boolean getCustomizer() { return customizer; }
    public ModifyUserInput setCustomizer(Boolean customizer) { this.customizer = customizer; return this; }

    public Boolean getVpn() { return vpn; }
    public ModifyUserInput setVpn(Boolean vpn) { this.vpn = vpn; return this; }

    public Boolean getService() { return service; }
    public ModifyUserInput setService(Boolean service) { this.service = service; return this; }

    public Boolean getEducation() { return education; }
    public ModifyUserInput setEducation(Boolean education) { this.education = education; return this; }

    public Boolean getSpecial() { return special; }
    public ModifyUserInput setSpecial(Boolean special) { this.special = special; return this; }

    public Boolean getFiltered() { return filtered; }
    public ModifyUserInput setFiltered(Boolean filtered) { this.filtered = filtered; return this; }

    public Boolean getResetSuspicion() { return resetSuspicion; }
    public ModifyUserInput setResetSuspicion(Boolean resetSuspicion) { this.resetSuspicion = resetSuspicion; return this; }

    public String getContact() { return contact; }
    public ModifyUserInput setContact(String contact) { this.contact = contact; return this; }

    public String getAdminComment() { return adminComment; }
    public ModifyUserInput setAdminComment(String adminComment) { this.adminComment = adminComment; return this; }
}
