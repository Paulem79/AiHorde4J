package net.paulem.aihorde4j.dto.params;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters for Stable Diffusion image generation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelGenerationInputStable {
    
    @JsonProperty("sampler_name")
    private String samplerName;
    
    @JsonProperty("cfg_scale")
    private Float cfgScale;
    
    @JsonProperty("height")
    private Integer height;
    
    @JsonProperty("width")
    private Integer width;
    
    @JsonProperty("steps")
    private Integer steps;
    
    @JsonProperty("seed")
    private String seed;
    
    @JsonProperty("clip_skip")
    private Integer clipSkip;
    
    @JsonProperty("karras")
    private Boolean karras;
    
    @JsonProperty("hires_fix")
    private Boolean hiresFix;
    
    @JsonProperty("denoising_strength")
    private Float denoisingStrength;
    
    @JsonProperty("n")
    private Integer n;
    
    public ModelGenerationInputStable() {
    }
    
    // Getters and Setters
    public String getSamplerName() {
        return samplerName;
    }
    
    public ModelGenerationInputStable setSamplerName(String samplerName) {
        this.samplerName = samplerName;
        return this;
    }
    
    public Float getCfgScale() {
        return cfgScale;
    }
    
    public ModelGenerationInputStable setCfgScale(Float cfgScale) {
        this.cfgScale = cfgScale;
        return this;
    }
    
    public Integer getHeight() {
        return height;
    }
    
    public ModelGenerationInputStable setHeight(Integer height) {
        this.height = height;
        return this;
    }
    
    public Integer getWidth() {
        return width;
    }
    
    public ModelGenerationInputStable setWidth(Integer width) {
        this.width = width;
        return this;
    }
    
    public Integer getSteps() {
        return steps;
    }
    
    public ModelGenerationInputStable setSteps(Integer steps) {
        this.steps = steps;
        return this;
    }
    
    public String getSeed() {
        return seed;
    }
    
    public ModelGenerationInputStable setSeed(String seed) {
        this.seed = seed;
        return this;
    }
    
    public Integer getClipSkip() {
        return clipSkip;
    }
    
    public ModelGenerationInputStable setClipSkip(Integer clipSkip) {
        this.clipSkip = clipSkip;
        return this;
    }
    
    public Boolean getKarras() {
        return karras;
    }
    
    public ModelGenerationInputStable setKarras(Boolean karras) {
        this.karras = karras;
        return this;
    }
    
    public Boolean getHiresFix() {
        return hiresFix;
    }
    
    public ModelGenerationInputStable setHiresFix(Boolean hiresFix) {
        this.hiresFix = hiresFix;
        return this;
    }
    
    public Float getDenoisingStrength() {
        return denoisingStrength;
    }
    
    public ModelGenerationInputStable setDenoisingStrength(Float denoisingStrength) {
        this.denoisingStrength = denoisingStrength;
        return this;
    }
    
    public Integer getN() {
        return n;
    }
    
    public ModelGenerationInputStable setN(Integer n) {
        this.n = n;
        return this;
    }
    
    /**
     * Creates a new builder for ModelGenerationInputStable.
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder class for ModelGenerationInputStable.
     */
    public static class Builder {
        private final ModelGenerationInputStable instance = new ModelGenerationInputStable();
        
        public Builder samplerName(String samplerName) {
            instance.setSamplerName(samplerName);
            return this;
        }
        
        public Builder cfgScale(Float cfgScale) {
            instance.setCfgScale(cfgScale);
            return this;
        }
        
        public Builder height(Integer height) {
            instance.setHeight(height);
            return this;
        }
        
        public Builder width(Integer width) {
            instance.setWidth(width);
            return this;
        }
        
        public Builder steps(Integer steps) {
            instance.setSteps(steps);
            return this;
        }
        
        public Builder seed(String seed) {
            instance.setSeed(seed);
            return this;
        }
        
        public Builder clipSkip(Integer clipSkip) {
            instance.setClipSkip(clipSkip);
            return this;
        }
        
        public Builder karras(Boolean karras) {
            instance.setKarras(karras);
            return this;
        }
        
        public Builder hiresFix(Boolean hiresFix) {
            instance.setHiresFix(hiresFix);
            return this;
        }
        
        public Builder denoisingStrength(Float denoisingStrength) {
            instance.setDenoisingStrength(denoisingStrength);
            return this;
        }
        
        public Builder n(Integer n) {
            instance.setN(n);
            return this;
        }
        
        public ModelGenerationInputStable build() {
            return instance;
        }
    }
}
