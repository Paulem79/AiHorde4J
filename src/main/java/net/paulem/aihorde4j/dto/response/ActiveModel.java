package net.paulem.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an active model available on the Horde.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveModel {
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("count")
    private Integer count;
    
    @JsonProperty("queued")
    private Double queued;
    
    @JsonProperty("jobs")
    private Double jobs;
    
    @JsonProperty("eta")
    private Integer eta;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("performance")
    private Double performance;
    
    public ActiveModel() {
    }
    
    public String getName() {
        return name;
    }
    
    public ActiveModel setName(String name) {
        this.name = name;
        return this;
    }
    
    public Integer getCount() {
        return count;
    }
    
    public ActiveModel setCount(Integer count) {
        this.count = count;
        return this;
    }
    
    public Double getQueued() {
        return queued;
    }
    
    public ActiveModel setQueued(Double queued) {
        this.queued = queued;
        return this;
    }
    
    public Double getJobs() {
        return jobs;
    }
    
    public ActiveModel setJobs(Double jobs) {
        this.jobs = jobs;
        return this;
    }
    
    public Integer getEta() {
        return eta;
    }
    
    public ActiveModel setEta(Integer eta) {
        this.eta = eta;
        return this;
    }
    
    public String getType() {
        return type;
    }
    
    public ActiveModel setType(String type) {
        this.type = type;
        return this;
    }
    
    public Double getPerformance() {
        return performance;
    }
    
    public ActiveModel setPerformance(Double performance) {
        this.performance = performance;
        return this;
    }
    
    @Override
    public String toString() {
        return "ActiveModel{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", queued=" + queued +
                ", jobs=" + jobs +
                ", eta=" + eta +
                ", type='" + type + '\'' +
                ", performance=" + performance +
                '}';
    }
}
