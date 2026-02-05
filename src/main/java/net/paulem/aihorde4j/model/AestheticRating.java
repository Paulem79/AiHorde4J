package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Input for rating an aesthetic.
 */
public class AestheticRating {
    @SerializedName("id")
    private String id;

    @SerializedName("rating")
    private Integer rating;

    @SerializedName("artifacts")
    private Integer artifacts;

    public AestheticRating() {}

    public String getId() { return id; }
    public AestheticRating setId(String id) { this.id = id; return this; }

    public Integer getRating() { return rating; }
    public AestheticRating setRating(Integer rating) { this.rating = rating; return this; }

    public Integer getArtifacts() { return artifacts; }
    public AestheticRating setArtifacts(Integer artifacts) { this.artifacts = artifacts; return this; }
}
