package io.github.aihorde4j.dto.params;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters for Kobold/LLM text generation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelGenerationInputKobold {
    
    @JsonProperty("max_context_length")
    private Integer maxContextLength;
    
    @JsonProperty("max_length")
    private Integer maxLength;
    
    @JsonProperty("temperature")
    private Float temperature;
    
    @JsonProperty("top_p")
    private Float topP;
    
    @JsonProperty("top_k")
    private Integer topK;
    
    @JsonProperty("top_a")
    private Float topA;
    
    @JsonProperty("typical")
    private Float typical;
    
    @JsonProperty("tfs")
    private Float tfs;
    
    @JsonProperty("rep_pen")
    private Float repPen;
    
    @JsonProperty("rep_pen_range")
    private Integer repPenRange;
    
    @JsonProperty("n")
    private Integer n;
    
    @JsonProperty("frmtadsnsp")
    private Boolean frmtadsnsp;
    
    @JsonProperty("frmtrmblln")
    private Boolean frmtrmblln;
    
    @JsonProperty("frmtrmspch")
    private Boolean frmtrmspch;
    
    @JsonProperty("frmttriminc")
    private Boolean frmttriminc;
    
    @JsonProperty("singleline")
    private Boolean singleline;
    
    public ModelGenerationInputKobold() {
    }
    
    // Getters and Setters
    public Integer getMaxContextLength() {
        return maxContextLength;
    }
    
    public ModelGenerationInputKobold setMaxContextLength(Integer maxContextLength) {
        this.maxContextLength = maxContextLength;
        return this;
    }
    
    public Integer getMaxLength() {
        return maxLength;
    }
    
    public ModelGenerationInputKobold setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }
    
    public Float getTemperature() {
        return temperature;
    }
    
    public ModelGenerationInputKobold setTemperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }
    
    public Float getTopP() {
        return topP;
    }
    
    public ModelGenerationInputKobold setTopP(Float topP) {
        this.topP = topP;
        return this;
    }
    
    public Integer getTopK() {
        return topK;
    }
    
    public ModelGenerationInputKobold setTopK(Integer topK) {
        this.topK = topK;
        return this;
    }
    
    public Float getTopA() {
        return topA;
    }
    
    public ModelGenerationInputKobold setTopA(Float topA) {
        this.topA = topA;
        return this;
    }
    
    public Float getTypical() {
        return typical;
    }
    
    public ModelGenerationInputKobold setTypical(Float typical) {
        this.typical = typical;
        return this;
    }
    
    public Float getTfs() {
        return tfs;
    }
    
    public ModelGenerationInputKobold setTfs(Float tfs) {
        this.tfs = tfs;
        return this;
    }
    
    public Float getRepPen() {
        return repPen;
    }
    
    public ModelGenerationInputKobold setRepPen(Float repPen) {
        this.repPen = repPen;
        return this;
    }
    
    public Integer getRepPenRange() {
        return repPenRange;
    }
    
    public ModelGenerationInputKobold setRepPenRange(Integer repPenRange) {
        this.repPenRange = repPenRange;
        return this;
    }
    
    public Integer getN() {
        return n;
    }
    
    public ModelGenerationInputKobold setN(Integer n) {
        this.n = n;
        return this;
    }
    
    public Boolean getFrmtadsnsp() {
        return frmtadsnsp;
    }
    
    public ModelGenerationInputKobold setFrmtadsnsp(Boolean frmtadsnsp) {
        this.frmtadsnsp = frmtadsnsp;
        return this;
    }
    
    public Boolean getFrmtrmblln() {
        return frmtrmblln;
    }
    
    public ModelGenerationInputKobold setFrmtrmblln(Boolean frmtrmblln) {
        this.frmtrmblln = frmtrmblln;
        return this;
    }
    
    public Boolean getFrmtrmspch() {
        return frmtrmspch;
    }
    
    public ModelGenerationInputKobold setFrmtrmspch(Boolean frmtrmspch) {
        this.frmtrmspch = frmtrmspch;
        return this;
    }
    
    public Boolean getFrmttriminc() {
        return frmttriminc;
    }
    
    public ModelGenerationInputKobold setFrmttriminc(Boolean frmttriminc) {
        this.frmttriminc = frmttriminc;
        return this;
    }
    
    public Boolean getSingleline() {
        return singleline;
    }
    
    public ModelGenerationInputKobold setSingleline(Boolean singleline) {
        this.singleline = singleline;
        return this;
    }
    
    /**
     * Creates a new builder for ModelGenerationInputKobold.
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder class for ModelGenerationInputKobold.
     */
    public static class Builder {
        private final ModelGenerationInputKobold instance = new ModelGenerationInputKobold();
        
        public Builder maxContextLength(Integer maxContextLength) {
            instance.setMaxContextLength(maxContextLength);
            return this;
        }
        
        public Builder maxLength(Integer maxLength) {
            instance.setMaxLength(maxLength);
            return this;
        }
        
        public Builder temperature(Float temperature) {
            instance.setTemperature(temperature);
            return this;
        }
        
        public Builder topP(Float topP) {
            instance.setTopP(topP);
            return this;
        }
        
        public Builder topK(Integer topK) {
            instance.setTopK(topK);
            return this;
        }
        
        public Builder topA(Float topA) {
            instance.setTopA(topA);
            return this;
        }
        
        public Builder typical(Float typical) {
            instance.setTypical(typical);
            return this;
        }
        
        public Builder tfs(Float tfs) {
            instance.setTfs(tfs);
            return this;
        }
        
        public Builder repPen(Float repPen) {
            instance.setRepPen(repPen);
            return this;
        }
        
        public Builder repPenRange(Integer repPenRange) {
            instance.setRepPenRange(repPenRange);
            return this;
        }
        
        public Builder n(Integer n) {
            instance.setN(n);
            return this;
        }
        
        public Builder frmtadsnsp(Boolean frmtadsnsp) {
            instance.setFrmtadsnsp(frmtadsnsp);
            return this;
        }
        
        public Builder frmtrmblln(Boolean frmtrmblln) {
            instance.setFrmtrmblln(frmtrmblln);
            return this;
        }
        
        public Builder frmtrmspch(Boolean frmtrmspch) {
            instance.setFrmtrmspch(frmtrmspch);
            return this;
        }
        
        public Builder frmttriminc(Boolean frmttriminc) {
            instance.setFrmttriminc(frmttriminc);
            return this;
        }
        
        public Builder singleline(Boolean singleline) {
            instance.setSingleline(singleline);
            return this;
        }
        
        public ModelGenerationInputKobold build() {
            return instance;
        }
    }
}
