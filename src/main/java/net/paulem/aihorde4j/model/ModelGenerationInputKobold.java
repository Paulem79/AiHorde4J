package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Generation parameters for text (KoboldAI).
 */
public class ModelGenerationInputKobold {
    @SerializedName("n")
    private Integer n;

    @SerializedName("frmtadsnsp")
    private Boolean frmtadsnsp;

    @SerializedName("frmtrmblln")
    private Boolean frmtrmblln;

    @SerializedName("frmtrmspch")
    private Boolean frmtrmspch;

    @SerializedName("frmttriminc")
    private Boolean frmttriminc;

    @SerializedName("max_context_length")
    private Integer maxContextLength;

    @SerializedName("max_length")
    private Integer maxLength;

    @SerializedName("rep_pen")
    private Double repPen;

    @SerializedName("rep_pen_range")
    private Integer repPenRange;

    @SerializedName("rep_pen_slope")
    private Double repPenSlope;

    @SerializedName("singleline")
    private Boolean singleline;

    @SerializedName("temperature")
    private Double temperature;

    @SerializedName("tfs")
    private Double tfs;

    @SerializedName("top_a")
    private Double topA;

    @SerializedName("top_k")
    private Integer topK;

    @SerializedName("top_p")
    private Double topP;

    @SerializedName("typical")
    private Double typical;

    @SerializedName("sampler_order")
    private List<Integer> samplerOrder;

    @SerializedName("stop_sequence")
    private List<String> stopSequence;

    @SerializedName("min_p")
    private Double minP;

    @SerializedName("dynatemp_range")
    private Double dynatempRange;

    @SerializedName("dynatemp_exponent")
    private Double dynatempExponent;

    @SerializedName("smoothing_factor")
    private Double smoothingFactor;

    public ModelGenerationInputKobold() {}

    public Integer getN() { return n; }
    public ModelGenerationInputKobold setN(Integer n) { this.n = n; return this; }

    public Boolean getFrmtadsnsp() { return frmtadsnsp; }
    public ModelGenerationInputKobold setFrmtadsnsp(Boolean frmtadsnsp) { this.frmtadsnsp = frmtadsnsp; return this; }

    public Boolean getFrmtrmblln() { return frmtrmblln; }
    public ModelGenerationInputKobold setFrmtrmblln(Boolean frmtrmblln) { this.frmtrmblln = frmtrmblln; return this; }

    public Boolean getFrmtrmspch() { return frmtrmspch; }
    public ModelGenerationInputKobold setFrmtrmspch(Boolean frmtrmspch) { this.frmtrmspch = frmtrmspch; return this; }

    public Boolean getFrmttriminc() { return frmttriminc; }
    public ModelGenerationInputKobold setFrmttriminc(Boolean frmttriminc) { this.frmttriminc = frmttriminc; return this; }

    public Integer getMaxContextLength() { return maxContextLength; }
    public ModelGenerationInputKobold setMaxContextLength(Integer maxContextLength) { this.maxContextLength = maxContextLength; return this; }

    public Integer getMaxLength() { return maxLength; }
    public ModelGenerationInputKobold setMaxLength(Integer maxLength) { this.maxLength = maxLength; return this; }

    public Double getRepPen() { return repPen; }
    public ModelGenerationInputKobold setRepPen(Double repPen) { this.repPen = repPen; return this; }

    public Integer getRepPenRange() { return repPenRange; }
    public ModelGenerationInputKobold setRepPenRange(Integer repPenRange) { this.repPenRange = repPenRange; return this; }

    public Double getRepPenSlope() { return repPenSlope; }
    public ModelGenerationInputKobold setRepPenSlope(Double repPenSlope) { this.repPenSlope = repPenSlope; return this; }

    public Boolean getSingleline() { return singleline; }
    public ModelGenerationInputKobold setSingleline(Boolean singleline) { this.singleline = singleline; return this; }

    public Double getTemperature() { return temperature; }
    public ModelGenerationInputKobold setTemperature(Double temperature) { this.temperature = temperature; return this; }

    public Double getTfs() { return tfs; }
    public ModelGenerationInputKobold setTfs(Double tfs) { this.tfs = tfs; return this; }

    public Double getTopA() { return topA; }
    public ModelGenerationInputKobold setTopA(Double topA) { this.topA = topA; return this; }

    public Integer getTopK() { return topK; }
    public ModelGenerationInputKobold setTopK(Integer topK) { this.topK = topK; return this; }

    public Double getTopP() { return topP; }
    public ModelGenerationInputKobold setTopP(Double topP) { this.topP = topP; return this; }

    public Double getTypical() { return typical; }
    public ModelGenerationInputKobold setTypical(Double typical) { this.typical = typical; return this; }

    public List<Integer> getSamplerOrder() { return samplerOrder; }
    public ModelGenerationInputKobold setSamplerOrder(List<Integer> samplerOrder) { this.samplerOrder = samplerOrder; return this; }

    public List<String> getStopSequence() { return stopSequence; }
    public ModelGenerationInputKobold setStopSequence(List<String> stopSequence) { this.stopSequence = stopSequence; return this; }

    public Double getMinP() { return minP; }
    public ModelGenerationInputKobold setMinP(Double minP) { this.minP = minP; return this; }

    public Double getDynatempRange() { return dynatempRange; }
    public ModelGenerationInputKobold setDynatempRange(Double dynatempRange) { this.dynatempRange = dynatempRange; return this; }

    public Double getDynatempExponent() { return dynatempExponent; }
    public ModelGenerationInputKobold setDynatempExponent(Double dynatempExponent) { this.dynatempExponent = dynatempExponent; return this; }

    public Double getSmoothingFactor() { return smoothingFactor; }
    public ModelGenerationInputKobold setSmoothingFactor(Double smoothingFactor) { this.smoothingFactor = smoothingFactor; return this; }
}
