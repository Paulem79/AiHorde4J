package net.paulem.aihorde4j.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.paulem.aihorde4j.dto.params.ModelGenerationInputStable;

import java.util.List;

/**
 * Request body for generating images with Stable Diffusion.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenerationInputStable {
    
    @JsonProperty("prompt")
    private String prompt;
    
    @JsonProperty("params")
    private ModelGenerationInputStable params;
    
    @JsonProperty("nsfw")
    private Boolean nsfw;
    
    @JsonProperty("censor_nsfw")
    private Boolean censorNsfw;
    
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
    
    @JsonProperty("source_image")
    private String sourceImage;
    
    @JsonProperty("source_processing")
    private String sourceProcessing;
    
    @JsonProperty("source_mask")
    private String sourceMask;
    
    @JsonProperty("r2")
    private Boolean r2;
    
    @JsonProperty("shared")
    private Boolean shared;
    
    @JsonProperty("replacement_filter")
    private Boolean replacementFilter;
    
    @JsonProperty("dry_run")
    private Boolean dryRun;
    
    public GenerationInputStable() {
    }
    
    public GenerationInputStable(String prompt) {
        this.prompt = prompt;
    }
    
    // Getters and Setters
    public String getPrompt() {
        return prompt;
    }
    
    public GenerationInputStable setPrompt(String prompt) {
        this.prompt = prompt;
        return this;
    }
    
    public ModelGenerationInputStable getParams() {
        return params;
    }
    
    public GenerationInputStable setParams(ModelGenerationInputStable params) {
        this.params = params;
        return this;
    }
    
    public Boolean getNsfw() {
        return nsfw;
    }
    
    public GenerationInputStable setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
        return this;
    }
    
    public Boolean getCensorNsfw() {
        return censorNsfw;
    }
    
    public GenerationInputStable setCensorNsfw(Boolean censorNsfw) {
        this.censorNsfw = censorNsfw;
        return this;
    }
    
    public Boolean getTrustedWorkers() {
        return trustedWorkers;
    }
    
    public GenerationInputStable setTrustedWorkers(Boolean trustedWorkers) {
        this.trustedWorkers = trustedWorkers;
        return this;
    }
    
    public Boolean getSlowWorkers() {
        return slowWorkers;
    }
    
    public GenerationInputStable setSlowWorkers(Boolean slowWorkers) {
        this.slowWorkers = slowWorkers;
        return this;
    }
    
    public List<String> getWorkers() {
        return workers;
    }
    
    public GenerationInputStable setWorkers(List<String> workers) {
        this.workers = workers;
        return this;
    }
    
    public Boolean getWorkerBlacklist() {
        return workerBlacklist;
    }
    
    public GenerationInputStable setWorkerBlacklist(Boolean workerBlacklist) {
        this.workerBlacklist = workerBlacklist;
        return this;
    }
    
    public List<String> getModels() {
        return models;
    }
    
    public GenerationInputStable setModels(List<String> models) {
        this.models = models;
        return this;
    }
    
    public String getSourceImage() {
        return sourceImage;
    }
    
    public GenerationInputStable setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
        return this;
    }
    
    public String getSourceProcessing() {
        return sourceProcessing;
    }
    
    public GenerationInputStable setSourceProcessing(String sourceProcessing) {
        this.sourceProcessing = sourceProcessing;
        return this;
    }
    
    public String getSourceMask() {
        return sourceMask;
    }
    
    public GenerationInputStable setSourceMask(String sourceMask) {
        this.sourceMask = sourceMask;
        return this;
    }
    
    public Boolean getR2() {
        return r2;
    }
    
    public GenerationInputStable setR2(Boolean r2) {
        this.r2 = r2;
        return this;
    }
    
    public Boolean getShared() {
        return shared;
    }
    
    public GenerationInputStable setShared(Boolean shared) {
        this.shared = shared;
        return this;
    }
    
    public Boolean getReplacementFilter() {
        return replacementFilter;
    }
    
    public GenerationInputStable setReplacementFilter(Boolean replacementFilter) {
        this.replacementFilter = replacementFilter;
        return this;
    }
    
    public Boolean getDryRun() {
        return dryRun;
    }
    
    public GenerationInputStable setDryRun(Boolean dryRun) {
        this.dryRun = dryRun;
        return this;
    }
    
    /**
     * Creates a new builder for GenerationInputStable.
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder class for GenerationInputStable.
     */
    public static class Builder {
        private final GenerationInputStable instance = new GenerationInputStable();
        
        public Builder prompt(String prompt) {
            instance.setPrompt(prompt);
            return this;
        }
        
        public Builder params(ModelGenerationInputStable params) {
            instance.setParams(params);
            return this;
        }
        
        public Builder nsfw(Boolean nsfw) {
            instance.setNsfw(nsfw);
            return this;
        }
        
        public Builder censorNsfw(Boolean censorNsfw) {
            instance.setCensorNsfw(censorNsfw);
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
        
        public Builder sourceImage(String sourceImage) {
            instance.setSourceImage(sourceImage);
            return this;
        }
        
        public Builder sourceProcessing(String sourceProcessing) {
            instance.setSourceProcessing(sourceProcessing);
            return this;
        }
        
        public Builder sourceMask(String sourceMask) {
            instance.setSourceMask(sourceMask);
            return this;
        }
        
        public Builder r2(Boolean r2) {
            instance.setR2(r2);
            return this;
        }
        
        public Builder shared(Boolean shared) {
            instance.setShared(shared);
            return this;
        }
        
        public Builder replacementFilter(Boolean replacementFilter) {
            instance.setReplacementFilter(replacementFilter);
            return this;
        }
        
        public Builder dryRun(Boolean dryRun) {
            instance.setDryRun(dryRun);
            return this;
        }
        
        public GenerationInputStable build() {
            return instance;
        }
    }
}
