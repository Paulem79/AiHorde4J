package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Input for kudos award.
 */
public class KudosAwardInput {
    @SerializedName("username")
    private String username;

    @SerializedName("amount")
    private Double amount;

    public KudosAwardInput() {}

    public KudosAwardInput(String username, Double amount) {
        this.username = username;
        this.amount = amount;
    }

    public String getUsername() { return username; }
    public KudosAwardInput setUsername(String username) { this.username = username; return this; }

    public Double getAmount() { return amount; }
    public KudosAwardInput setAmount(Double amount) { this.amount = amount; return this; }
}
