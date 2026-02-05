package io.github.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single generated text result.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerationKobold {
    
    @JsonProperty("worker_id")
    private String workerId;
    
    @JsonProperty("worker_name")
    private String workerName;
    
    @JsonProperty("model")
    private String model;
    
    @JsonProperty("text")
    private String text;
    
    @JsonProperty("seed")
    private Long seed;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("state")
    private String state;
    
    public GenerationKobold() {
    }
    
    public String getWorkerId() {
        return workerId;
    }
    
    public GenerationKobold setWorkerId(String workerId) {
        this.workerId = workerId;
        return this;
    }
    
    public String getWorkerName() {
        return workerName;
    }
    
    public GenerationKobold setWorkerName(String workerName) {
        this.workerName = workerName;
        return this;
    }
    
    public String getModel() {
        return model;
    }
    
    public GenerationKobold setModel(String model) {
        this.model = model;
        return this;
    }
    
    public String getText() {
        return text;
    }
    
    public GenerationKobold setText(String text) {
        this.text = text;
        return this;
    }
    
    public Long getSeed() {
        return seed;
    }
    
    public GenerationKobold setSeed(Long seed) {
        this.seed = seed;
        return this;
    }
    
    public String getId() {
        return id;
    }
    
    public GenerationKobold setId(String id) {
        this.id = id;
        return this;
    }
    
    public String getState() {
        return state;
    }
    
    public GenerationKobold setState(String state) {
        this.state = state;
        return this;
    }
    
    @Override
    public String toString() {
        return "GenerationKobold{" +
                "workerId='" + workerId + '\'' +
                ", workerName='" + workerName + '\'' +
                ", model='" + model + '\'' +
                ", text='" + (text != null ? text.substring(0, Math.min(50, text.length())) + "..." : null) + '\'' +
                ", seed=" + seed +
                ", id='" + id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
