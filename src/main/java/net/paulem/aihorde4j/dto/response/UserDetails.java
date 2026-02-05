package net.paulem.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * User details from the API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("kudos")
    private Double kudos;
    
    @JsonProperty("evaluating_kudos")
    private Double evaluatingKudos;
    
    @JsonProperty("concurrency")
    private Integer concurrency;
    
    @JsonProperty("worker_invited")
    private Integer workerInvited;
    
    @JsonProperty("moderator")
    private Boolean moderator;
    
    @JsonProperty("kudos_details")
    private Map<String, Double> kudosDetails;
    
    @JsonProperty("worker_count")
    private Integer workerCount;
    
    @JsonProperty("worker_ids")
    private String[] workerIds;
    
    @JsonProperty("monthly_kudos")
    private Map<String, Object> monthlyKudos;
    
    @JsonProperty("trusted")
    private Boolean trusted;
    
    @JsonProperty("flagged")
    private Boolean flagged;
    
    @JsonProperty("vpn")
    private Boolean vpn;
    
    @JsonProperty("special")
    private Boolean special;
    
    @JsonProperty("pseudonymous")
    private Boolean pseudonymous;
    
    @JsonProperty("account_age")
    private Integer accountAge;
    
    @JsonProperty("usage")
    private Map<String, Object> usage;
    
    @JsonProperty("contributions")
    private Map<String, Object> contributions;
    
    @JsonProperty("records")
    private Map<String, Object> records;
    
    public UserDetails() {
    }
    
    public String getUsername() {
        return username;
    }
    
    public UserDetails setUsername(String username) {
        this.username = username;
        return this;
    }
    
    public Integer getId() {
        return id;
    }
    
    public UserDetails setId(Integer id) {
        this.id = id;
        return this;
    }
    
    public Double getKudos() {
        return kudos;
    }
    
    public UserDetails setKudos(Double kudos) {
        this.kudos = kudos;
        return this;
    }
    
    public Double getEvaluatingKudos() {
        return evaluatingKudos;
    }
    
    public UserDetails setEvaluatingKudos(Double evaluatingKudos) {
        this.evaluatingKudos = evaluatingKudos;
        return this;
    }
    
    public Integer getConcurrency() {
        return concurrency;
    }
    
    public UserDetails setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
        return this;
    }
    
    public Integer getWorkerInvited() {
        return workerInvited;
    }
    
    public UserDetails setWorkerInvited(Integer workerInvited) {
        this.workerInvited = workerInvited;
        return this;
    }
    
    public Boolean getModerator() {
        return moderator;
    }
    
    public UserDetails setModerator(Boolean moderator) {
        this.moderator = moderator;
        return this;
    }
    
    public Map<String, Double> getKudosDetails() {
        return kudosDetails;
    }
    
    public UserDetails setKudosDetails(Map<String, Double> kudosDetails) {
        this.kudosDetails = kudosDetails;
        return this;
    }
    
    public Integer getWorkerCount() {
        return workerCount;
    }
    
    public UserDetails setWorkerCount(Integer workerCount) {
        this.workerCount = workerCount;
        return this;
    }
    
    public String[] getWorkerIds() {
        return workerIds;
    }
    
    public UserDetails setWorkerIds(String[] workerIds) {
        this.workerIds = workerIds;
        return this;
    }
    
    public Map<String, Object> getMonthlyKudos() {
        return monthlyKudos;
    }
    
    public UserDetails setMonthlyKudos(Map<String, Object> monthlyKudos) {
        this.monthlyKudos = monthlyKudos;
        return this;
    }
    
    public Boolean getTrusted() {
        return trusted;
    }
    
    public UserDetails setTrusted(Boolean trusted) {
        this.trusted = trusted;
        return this;
    }
    
    public Boolean getFlagged() {
        return flagged;
    }
    
    public UserDetails setFlagged(Boolean flagged) {
        this.flagged = flagged;
        return this;
    }
    
    public Boolean getVpn() {
        return vpn;
    }
    
    public UserDetails setVpn(Boolean vpn) {
        this.vpn = vpn;
        return this;
    }
    
    public Boolean getSpecial() {
        return special;
    }
    
    public UserDetails setSpecial(Boolean special) {
        this.special = special;
        return this;
    }
    
    public Boolean getPseudonymous() {
        return pseudonymous;
    }
    
    public UserDetails setPseudonymous(Boolean pseudonymous) {
        this.pseudonymous = pseudonymous;
        return this;
    }
    
    public Integer getAccountAge() {
        return accountAge;
    }
    
    public UserDetails setAccountAge(Integer accountAge) {
        this.accountAge = accountAge;
        return this;
    }
    
    public Map<String, Object> getUsage() {
        return usage;
    }
    
    public UserDetails setUsage(Map<String, Object> usage) {
        this.usage = usage;
        return this;
    }
    
    public Map<String, Object> getContributions() {
        return contributions;
    }
    
    public UserDetails setContributions(Map<String, Object> contributions) {
        this.contributions = contributions;
        return this;
    }
    
    public Map<String, Object> getRecords() {
        return records;
    }
    
    public UserDetails setRecords(Map<String, Object> records) {
        this.records = records;
        return this;
    }
    
    @Override
    public String toString() {
        return "UserDetails{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", kudos=" + kudos +
                ", moderator=" + moderator +
                ", trusted=" + trusted +
                ", workerCount=" + workerCount +
                '}';
    }
}
