package io.github.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from check endpoint containing the status of a generation request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestStatusCheck {
    
    @JsonProperty("finished")
    private Integer finished;
    
    @JsonProperty("processing")
    private Integer processing;
    
    @JsonProperty("restarted")
    private Integer restarted;
    
    @JsonProperty("waiting")
    private Integer waiting;
    
    @JsonProperty("done")
    private Boolean done;
    
    @JsonProperty("faulted")
    private Boolean faulted;
    
    @JsonProperty("wait_time")
    private Integer waitTime;
    
    @JsonProperty("queue_position")
    private Integer queuePosition;
    
    @JsonProperty("kudos")
    private Double kudos;
    
    @JsonProperty("is_possible")
    private Boolean isPossible;
    
    public RequestStatusCheck() {
    }
    
    // Getters
    public Integer getFinished() {
        return finished;
    }
    
    public RequestStatusCheck setFinished(Integer finished) {
        this.finished = finished;
        return this;
    }
    
    public Integer getProcessing() {
        return processing;
    }
    
    public RequestStatusCheck setProcessing(Integer processing) {
        this.processing = processing;
        return this;
    }
    
    public Integer getRestarted() {
        return restarted;
    }
    
    public RequestStatusCheck setRestarted(Integer restarted) {
        this.restarted = restarted;
        return this;
    }
    
    public Integer getWaiting() {
        return waiting;
    }
    
    public RequestStatusCheck setWaiting(Integer waiting) {
        this.waiting = waiting;
        return this;
    }
    
    public Boolean getDone() {
        return done;
    }
    
    public RequestStatusCheck setDone(Boolean done) {
        this.done = done;
        return this;
    }
    
    public Boolean getFaulted() {
        return faulted;
    }
    
    public RequestStatusCheck setFaulted(Boolean faulted) {
        this.faulted = faulted;
        return this;
    }
    
    public Integer getWaitTime() {
        return waitTime;
    }
    
    public RequestStatusCheck setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
        return this;
    }
    
    public Integer getQueuePosition() {
        return queuePosition;
    }
    
    public RequestStatusCheck setQueuePosition(Integer queuePosition) {
        this.queuePosition = queuePosition;
        return this;
    }
    
    public Double getKudos() {
        return kudos;
    }
    
    public RequestStatusCheck setKudos(Double kudos) {
        this.kudos = kudos;
        return this;
    }
    
    public Boolean getIsPossible() {
        return isPossible;
    }
    
    public RequestStatusCheck setIsPossible(Boolean isPossible) {
        this.isPossible = isPossible;
        return this;
    }
    
    /**
     * Checks if the request is complete.
     */
    public boolean isComplete() {
        return Boolean.TRUE.equals(done);
    }
    
    /**
     * Checks if the request has failed.
     */
    public boolean hasFailed() {
        return Boolean.TRUE.equals(faulted);
    }
    
    @Override
    public String toString() {
        return "RequestStatusCheck{" +
                "finished=" + finished +
                ", processing=" + processing +
                ", restarted=" + restarted +
                ", waiting=" + waiting +
                ", done=" + done +
                ", faulted=" + faulted +
                ", waitTime=" + waitTime +
                ", queuePosition=" + queuePosition +
                ", kudos=" + kudos +
                ", isPossible=" + isPossible +
                '}';
    }
}
