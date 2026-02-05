package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Input for stable diffusion image generation.
 */
public class GenerationInputStable {
    @SerializedName("prompt")
    private String prompt;

    @SerializedName("params")
    private ModelGenerationInputStable params;

    @SerializedName("nsfw")
    private Boolean nsfw;

    @SerializedName("trusted_workers")
    private Boolean trustedWorkers;

    @SerializedName("slow_workers")
    private Boolean slowWorkers;

    @SerializedName("censor_nsfw")
    private Boolean censorNsfw;

    @SerializedName("workers")
    private List<String> workers;

    @SerializedName("worker_blacklist")
    private Boolean workerBlacklist;

    @SerializedName("models")
    private List<String> models;

    @SerializedName("source_image")
    private String sourceImage;

    @SerializedName("source_processing")
    private String sourceProcessing;

    @SerializedName("source_mask")
    private String sourceMask;

    @SerializedName("extra_source_images")
    private List<ExtraSourceImage> extraSourceImages;

    @SerializedName("r2")
    private Boolean r2;

    @SerializedName("shared")
    private Boolean shared;

    @SerializedName("replacement_filter")
    private Boolean replacementFilter;

    @SerializedName("dry_run")
    private Boolean dryRun;

    @SerializedName("proxied_account")
    private String proxiedAccount;

    @SerializedName("disable_batching")
    private Boolean disableBatching;

    @SerializedName("allow_downgrade")
    private Boolean allowDowngrade;

    @SerializedName("webhook")
    private String webhook;

    public GenerationInputStable() {}

    public GenerationInputStable(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() { return prompt; }
    public GenerationInputStable setPrompt(String prompt) { this.prompt = prompt; return this; }

    public ModelGenerationInputStable getParams() { return params; }
    public GenerationInputStable setParams(ModelGenerationInputStable params) { this.params = params; return this; }

    public Boolean getNsfw() { return nsfw; }
    public GenerationInputStable setNsfw(Boolean nsfw) { this.nsfw = nsfw; return this; }

    public Boolean getTrustedWorkers() { return trustedWorkers; }
    public GenerationInputStable setTrustedWorkers(Boolean trustedWorkers) { this.trustedWorkers = trustedWorkers; return this; }

    public Boolean getSlowWorkers() { return slowWorkers; }
    public GenerationInputStable setSlowWorkers(Boolean slowWorkers) { this.slowWorkers = slowWorkers; return this; }

    public Boolean getCensorNsfw() { return censorNsfw; }
    public GenerationInputStable setCensorNsfw(Boolean censorNsfw) { this.censorNsfw = censorNsfw; return this; }

    public List<String> getWorkers() { return workers; }
    public GenerationInputStable setWorkers(List<String> workers) { this.workers = workers; return this; }

    public Boolean getWorkerBlacklist() { return workerBlacklist; }
    public GenerationInputStable setWorkerBlacklist(Boolean workerBlacklist) { this.workerBlacklist = workerBlacklist; return this; }

    public List<String> getModels() { return models; }
    public GenerationInputStable setModels(List<String> models) { this.models = models; return this; }

    public String getSourceImage() { return sourceImage; }
    public GenerationInputStable setSourceImage(String sourceImage) { this.sourceImage = sourceImage; return this; }

    public String getSourceProcessing() { return sourceProcessing; }
    public GenerationInputStable setSourceProcessing(String sourceProcessing) { this.sourceProcessing = sourceProcessing; return this; }

    public String getSourceMask() { return sourceMask; }
    public GenerationInputStable setSourceMask(String sourceMask) { this.sourceMask = sourceMask; return this; }

    public List<ExtraSourceImage> getExtraSourceImages() { return extraSourceImages; }
    public GenerationInputStable setExtraSourceImages(List<ExtraSourceImage> extraSourceImages) { this.extraSourceImages = extraSourceImages; return this; }

    public Boolean getR2() { return r2; }
    public GenerationInputStable setR2(Boolean r2) { this.r2 = r2; return this; }

    public Boolean getShared() { return shared; }
    public GenerationInputStable setShared(Boolean shared) { this.shared = shared; return this; }

    public Boolean getReplacementFilter() { return replacementFilter; }
    public GenerationInputStable setReplacementFilter(Boolean replacementFilter) { this.replacementFilter = replacementFilter; return this; }

    public Boolean getDryRun() { return dryRun; }
    public GenerationInputStable setDryRun(Boolean dryRun) { this.dryRun = dryRun; return this; }

    public String getProxiedAccount() { return proxiedAccount; }
    public GenerationInputStable setProxiedAccount(String proxiedAccount) { this.proxiedAccount = proxiedAccount; return this; }

    public Boolean getDisableBatching() { return disableBatching; }
    public GenerationInputStable setDisableBatching(Boolean disableBatching) { this.disableBatching = disableBatching; return this; }

    public Boolean getAllowDowngrade() { return allowDowngrade; }
    public GenerationInputStable setAllowDowngrade(Boolean allowDowngrade) { this.allowDowngrade = allowDowngrade; return this; }

    public String getWebhook() { return webhook; }
    public GenerationInputStable setWebhook(String webhook) { this.webhook = webhook; return this; }
}
