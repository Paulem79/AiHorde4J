package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Input for image interrogation.
 */
public class ModelInterrogationInputStable {
    @SerializedName("forms")
    private List<ModelInterrogationFormStable> forms;

    @SerializedName("source_image")
    private String sourceImage;

    @SerializedName("slow_workers")
    private Boolean slowWorkers;

    @SerializedName("webhook")
    private String webhook;

    public ModelInterrogationInputStable() {}

    public ModelInterrogationInputStable(String sourceImage, List<ModelInterrogationFormStable> forms) {
        this.sourceImage = sourceImage;
        this.forms = forms;
    }

    public List<ModelInterrogationFormStable> getForms() { return forms; }
    public ModelInterrogationInputStable setForms(List<ModelInterrogationFormStable> forms) { this.forms = forms; return this; }

    public String getSourceImage() { return sourceImage; }
    public ModelInterrogationInputStable setSourceImage(String sourceImage) { this.sourceImage = sourceImage; return this; }

    public Boolean getSlowWorkers() { return slowWorkers; }
    public ModelInterrogationInputStable setSlowWorkers(Boolean slowWorkers) { this.slowWorkers = slowWorkers; return this; }

    public String getWebhook() { return webhook; }
    public ModelInterrogationInputStable setWebhook(String webhook) { this.webhook = webhook; return this; }
}
