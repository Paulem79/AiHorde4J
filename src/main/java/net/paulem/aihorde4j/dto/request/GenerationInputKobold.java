package net.paulem.aihorde4j.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.paulem.aihorde4j.dto.params.ModelGenerationInputKobold;

import java.util.List;

/**
 * Request body for generating text with Kobold/LLM.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenerationInputKobold {
    
    @JsonProperty("prompt")
    private String prompt;
    
    @JsonProperty("params")
    private ModelGenerationInputKobold params;
    
    @JsonProperty("trusted_workers")
    private Boolean trustedWorkers;
    
    @JsonProperty("slow_workers")
    private Boolean slowWorkers;
    
    @JsonProperty("workers")
    private List<String> workers;
    
    @JsonProperty("worker_blacklist")
    private Boolean workerBlacklist;
    
    @JsonProperty("models")
    private List<String> models;
    
    @JsonProperty("dry_run")
    private Boolean dryRun;
    
    public GenerationInputKobold() {
    }
    
    public GenerationInputKobold(String prompt) {
        this.prompt = prompt;
    }
    
    // Getters and Setters
    public String getPrompt() {
        return prompt;
    }
    
    public GenerationInputKobold setPrompt(String prompt) {
        this.prompt = prompt;
        return this;
    }
    
    public ModelGenerationInputKobold getParams() {
        return params;
    }
    
    public GenerationInputKobold setParams(ModelGenerationInputKobold params) {
        this.params = params;
        return this;
    }
    
    public Boolean getTrustedWorkers() {
        return trustedWorkers;
    }
    
    public GenerationInputKobold setTrustedWorkers(Boolean trustedWorkers) {
        this.trustedWorkers = trustedWorkers;
        return this;
    }
    
    public Boolean getSlowWorkers() {
        return slowWorkers;
    }
    
    public GenerationInputKobold setSlowWorkers(Boolean slowWorkers) {
        this.slowWorkers = slowWorkers;
        return this;
    }
    
    public List<String> getWorkers() {
        return workers;
    }
    
    public GenerationInputKobold setWorkers(List<String> workers) {
        this.workers = workers;
        return this;
    }
    
    public Boolean getWorkerBlacklist() {
        return workerBlacklist;
    }
    
    public GenerationInputKobold setWorkerBlacklist(Boolean workerBlacklist) {
        this.workerBlacklist = workerBlacklist;
        return this;
    }
    
    public List<String> getModels() {
        return models;
    }
    
    public GenerationInputKobold setModels(List<String> models) {
        this.models = models;
        return this;
    }
    
    public Boolean getDryRun() {
        return dryRun;
    }
    
    public GenerationInputKobold setDryRun(Boolean dryRun) {
        this.dryRun = dryRun;
        return this;
    }
    
    /**
     * Creates a new builder for GenerationInputKobold.
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder class for GenerationInputKobold.
     */
    public static class Builder {
        private final GenerationInputKobold instance = new GenerationInputKobold();
        
        public Builder prompt(String prompt) {
            instance.setPrompt(prompt);
            return this;
        }
        
        public Builder params(ModelGenerationInputKobold params) {
            instance.setParams(params);
            return this;
        }
        
        public Builder trustedWorkers(Boolean trustedWorkers) {
            instance.setTrustedWorkers(trustedWorkers);
            return this;
        }
        
        public Builder slowWorkers(Boolean slowWorkers) {
            instance.setSlowWorkers(slowWorkers);
            return this;
        }
        
        public Builder workers(List<String> workers) {
            instance.setWorkers(workers);
            return this;
        }
        
        public Builder workerBlacklist(Boolean workerBlacklist) {
            instance.setWorkerBlacklist(workerBlacklist);
            return this;
        }
        
        public Builder models(List<String> models) {
            instance.setModels(models);
            return this;
        }
        
        public Builder dryRun(Boolean dryRun) {
            instance.setDryRun(dryRun);
            return this;
        }
        
        public GenerationInputKobold build() {
            return instance;
        }
    }
}
