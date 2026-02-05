package io.github.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single generated image result.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Generation {
    
    @JsonProperty("worker_id")
    private String workerId;
    
    @JsonProperty("worker_name")
    private String workerName;
    
    @JsonProperty("model")
    private String model;
    
    @JsonProperty("img")
    private String img;
    
    @JsonProperty("seed")
    private String seed;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("censored")
    private Boolean censored;
    
    @JsonProperty("state")
    private String state;
    
    public Generation() {
    }
    
    public String getWorkerId() {
        return workerId;
    }
    
    public Generation setWorkerId(String workerId) {
        this.workerId = workerId;
        return this;
    }
    
    public String getWorkerName() {
        return workerName;
    }
    
    public Generation setWorkerName(String workerName) {
        this.workerName = workerName;
        return this;
    }
    
    public String getModel() {
        return model;
    }
    
    public Generation setModel(String model) {
        this.model = model;
        return this;
    }
    
    public String getImg() {
        return img;
    }
    
    public Generation setImg(String img) {
        this.img = img;
        return this;
    }
    
    public String getSeed() {
        return seed;
    }
    
    public Generation setSeed(String seed) {
        this.seed = seed;
        return this;
    }
    
    public String getId() {
        return id;
    }
    
    public Generation setId(String id) {
        this.id = id;
        return this;
    }
    
    public Boolean getCensored() {
        return censored;
    }
    
    public Generation setCensored(Boolean censored) {
        this.censored = censored;
        return this;
    }
    
    public String getState() {
        return state;
    }
    
    public Generation setState(String state) {
        this.state = state;
        return this;
    }
    
    @Override
    public String toString() {
        return "Generation{" +
                "workerId='" + workerId + '\'' +
                ", workerName='" + workerName + '\'' +
                ", model='" + model + '\'' +
                ", img='" + (img != null ? img.substring(0, Math.min(50, img.length())) + "..." : null) + '\'' +
                ", seed='" + seed + '\'' +
                ", id='" + id + '\'' +
                ", censored=" + censored +
                ", state='" + state + '\'' +
                '}';
    }
}
