package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Payload for aesthetics rating.
 */
public class AestheticsPayload {
    @SerializedName("best")
    private String best;

    @SerializedName("ratings")
    private List<AestheticRating> ratings;

    public AestheticsPayload() {}

    public String getBest() { return best; }
    public AestheticsPayload setBest(String best) { this.best = best; return this; }

    public List<AestheticRating> getRatings() { return ratings; }
    public AestheticsPayload setRatings(List<AestheticRating> ratings) { this.ratings = ratings; return this; }
}
