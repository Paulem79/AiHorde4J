package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Generation parameters for stable diffusion.
 */
public class ModelGenerationInputStable {
    @SerializedName("sampler_name")
    private String samplerName;

    @SerializedName("cfg_scale")
    private Double cfgScale;

    @SerializedName("denoising_strength")
    private Double denoisingStrength;

    @SerializedName("seed")
    private String seed;

    @SerializedName("height")
    private Integer height;

    @SerializedName("width")
    private Integer width;

    @SerializedName("seed_variation")
    private Integer seedVariation;

    @SerializedName("post_processing")
    private List<String> postProcessing;

    @SerializedName("karras")
    private Boolean karras;

    @SerializedName("tiling")
    private Boolean tiling;

    @SerializedName("hires_fix")
    private Boolean hiresFix;

    @SerializedName("clip_skip")
    private Integer clipSkip;

    @SerializedName("control_type")
    private String controlType;

    @SerializedName("image_is_control")
    private Boolean imageIsControl;

    @SerializedName("return_control_map")
    private Boolean returnControlMap;

    @SerializedName("facefixer_strength")
    private Double facefixerStrength;

    @SerializedName("loras")
    private List<ModelPayloadLorasStable> loras;

    @SerializedName("tis")
    private List<ModelPayloadTextualInversionsStable> tis;

    @SerializedName("special")
    private ModelSpecialPayloadStable special;

    @SerializedName("steps")
    private Integer steps;

    @SerializedName("n")
    private Integer n;

    public ModelGenerationInputStable() {}

    public String getSamplerName() { return samplerName; }
    public ModelGenerationInputStable setSamplerName(String samplerName) { this.samplerName = samplerName; return this; }

    public Double getCfgScale() { return cfgScale; }
    public ModelGenerationInputStable setCfgScale(Double cfgScale) { this.cfgScale = cfgScale; return this; }

    public Double getDenoisingStrength() { return denoisingStrength; }
    public ModelGenerationInputStable setDenoisingStrength(Double denoisingStrength) { this.denoisingStrength = denoisingStrength; return this; }

    public String getSeed() { return seed; }
    public ModelGenerationInputStable setSeed(String seed) { this.seed = seed; return this; }

    public Integer getHeight() { return height; }
    public ModelGenerationInputStable setHeight(Integer height) { this.height = height; return this; }

    public Integer getWidth() { return width; }
    public ModelGenerationInputStable setWidth(Integer width) { this.width = width; return this; }

    public Integer getSeedVariation() { return seedVariation; }
    public ModelGenerationInputStable setSeedVariation(Integer seedVariation) { this.seedVariation = seedVariation; return this; }

    public List<String> getPostProcessing() { return postProcessing; }
    public ModelGenerationInputStable setPostProcessing(List<String> postProcessing) { this.postProcessing = postProcessing; return this; }

    public Boolean getKarras() { return karras; }
    public ModelGenerationInputStable setKarras(Boolean karras) { this.karras = karras; return this; }

    public Boolean getTiling() { return tiling; }
    public ModelGenerationInputStable setTiling(Boolean tiling) { this.tiling = tiling; return this; }

    public Boolean getHiresFix() { return hiresFix; }
    public ModelGenerationInputStable setHiresFix(Boolean hiresFix) { this.hiresFix = hiresFix; return this; }

    public Integer getClipSkip() { return clipSkip; }
    public ModelGenerationInputStable setClipSkip(Integer clipSkip) { this.clipSkip = clipSkip; return this; }

    public String getControlType() { return controlType; }
    public ModelGenerationInputStable setControlType(String controlType) { this.controlType = controlType; return this; }

    public Boolean getImageIsControl() { return imageIsControl; }
    public ModelGenerationInputStable setImageIsControl(Boolean imageIsControl) { this.imageIsControl = imageIsControl; return this; }

    public Boolean getReturnControlMap() { return returnControlMap; }
    public ModelGenerationInputStable setReturnControlMap(Boolean returnControlMap) { this.returnControlMap = returnControlMap; return this; }

    public Double getFacefixerStrength() { return facefixerStrength; }
    public ModelGenerationInputStable setFacefixerStrength(Double facefixerStrength) { this.facefixerStrength = facefixerStrength; return this; }

    public List<ModelPayloadLorasStable> getLoras() { return loras; }
    public ModelGenerationInputStable setLoras(List<ModelPayloadLorasStable> loras) { this.loras = loras; return this; }

    public List<ModelPayloadTextualInversionsStable> getTis() { return tis; }
    public ModelGenerationInputStable setTis(List<ModelPayloadTextualInversionsStable> tis) { this.tis = tis; return this; }

    public ModelSpecialPayloadStable getSpecial() { return special; }
    public ModelGenerationInputStable setSpecial(ModelSpecialPayloadStable special) { this.special = special; return this; }

    public Integer getSteps() { return steps; }
    public ModelGenerationInputStable setSteps(Integer steps) { this.steps = steps; return this; }

    public Integer getN() { return n; }
    public ModelGenerationInputStable setN(Integer n) { this.n = n; return this; }
}
