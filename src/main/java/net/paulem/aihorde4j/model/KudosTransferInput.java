package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;

/**
 * Input for kudos transfer.
 */
public class KudosTransferInput {
    @SerializedName("username")
    private String username;

    @SerializedName("amount")
    private Double amount;

    public KudosTransferInput() {}

    public KudosTransferInput(String username, Double amount) {
        this.username = username;
        this.amount = amount;
    }

    public String getUsername() { return username; }
    public KudosTransferInput setUsername(String username) { this.username = username; return this; }

    public Double getAmount() { return amount; }
    public KudosTransferInput setAmount(Double amount) { this.amount = amount; return this; }
}
