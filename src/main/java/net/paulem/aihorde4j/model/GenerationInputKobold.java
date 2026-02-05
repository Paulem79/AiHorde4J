package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Input for text generation.
 */
public class GenerationInputKobold {
    @SerializedName("prompt")
    private String prompt;

    @SerializedName("params")
    private ModelGenerationInputKobold params;

    @SerializedName("softprompt")
    private String softprompt;

    @SerializedName("trusted_workers")
    private Boolean trustedWorkers;

    @SerializedName("slow_workers")
    private Boolean slowWorkers;

    @SerializedName("workers")
    private List<String> workers;

    @SerializedName("worker_blacklist")
    private Boolean workerBlacklist;

    @SerializedName("models")
    private List<String> models;

    @SerializedName("dry_run")
    private Boolean dryRun;

    @SerializedName("proxied_account")
    private String proxiedAccount;

    @SerializedName("extra_source_images")
    private List<ExtraSourceImage> extraSourceImages;

    @SerializedName("disable_batching")
    private Boolean disableBatching;

    @SerializedName("allow_downgrade")
    private Boolean allowDowngrade;

    @SerializedName("webhook")
    private String webhook;

    public GenerationInputKobold() {}

    public GenerationInputKobold(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() { return prompt; }
    public GenerationInputKobold setPrompt(String prompt) { this.prompt = prompt; return this; }

    public ModelGenerationInputKobold getParams() { return params; }
    public GenerationInputKobold setParams(ModelGenerationInputKobold params) { this.params = params; return this; }

    public String getSoftprompt() { return softprompt; }
    public GenerationInputKobold setSoftprompt(String softprompt) { this.softprompt = softprompt; return this; }

    public Boolean getTrustedWorkers() { return trustedWorkers; }
    public GenerationInputKobold setTrustedWorkers(Boolean trustedWorkers) { this.trustedWorkers = trustedWorkers; return this; }

    public Boolean getSlowWorkers() { return slowWorkers; }
    public GenerationInputKobold setSlowWorkers(Boolean slowWorkers) { this.slowWorkers = slowWorkers; return this; }

    public List<String> getWorkers() { return workers; }
    public GenerationInputKobold setWorkers(List<String> workers) { this.workers = workers; return this; }

    public Boolean getWorkerBlacklist() { return workerBlacklist; }
    public GenerationInputKobold setWorkerBlacklist(Boolean workerBlacklist) { this.workerBlacklist = workerBlacklist; return this; }

    public List<String> getModels() { return models; }
    public GenerationInputKobold setModels(List<String> models) { this.models = models; return this; }

    public Boolean getDryRun() { return dryRun; }
    public GenerationInputKobold setDryRun(Boolean dryRun) { this.dryRun = dryRun; return this; }

    public String getProxiedAccount() { return proxiedAccount; }
    public GenerationInputKobold setProxiedAccount(String proxiedAccount) { this.proxiedAccount = proxiedAccount; return this; }

    public List<ExtraSourceImage> getExtraSourceImages() { return extraSourceImages; }
    public GenerationInputKobold setExtraSourceImages(List<ExtraSourceImage> extraSourceImages) { this.extraSourceImages = extraSourceImages; return this; }

    public Boolean getDisableBatching() { return disableBatching; }
    public GenerationInputKobold setDisableBatching(Boolean disableBatching) { this.disableBatching = disableBatching; return this; }

    public Boolean getAllowDowngrade() { return allowDowngrade; }
    public GenerationInputKobold setAllowDowngrade(Boolean allowDowngrade) { this.allowDowngrade = allowDowngrade; return this; }

    public String getWebhook() { return webhook; }
    public GenerationInputKobold setWebhook(String webhook) { this.webhook = webhook; return this; }
}
