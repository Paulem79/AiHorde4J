package io.github.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Response containing the final status and results of a Kobold text generation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestStatusKobold {
    
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
    
    @JsonProperty("generations")
    private List<GenerationKobold> generations;
    
    public RequestStatusKobold() {
    }
    
    public Integer getFinished() {
        return finished;
    }
    
    public RequestStatusKobold setFinished(Integer finished) {
        this.finished = finished;
        return this;
    }
    
    public Integer getProcessing() {
        return processing;
    }
    
    public RequestStatusKobold setProcessing(Integer processing) {
        this.processing = processing;
        return this;
    }
    
    public Integer getRestarted() {
        return restarted;
    }
    
    public RequestStatusKobold setRestarted(Integer restarted) {
        this.restarted = restarted;
        return this;
    }
    
    public Integer getWaiting() {
        return waiting;
    }
    
    public RequestStatusKobold setWaiting(Integer waiting) {
        this.waiting = waiting;
        return this;
    }
    
    public Boolean getDone() {
        return done;
    }
    
    public RequestStatusKobold setDone(Boolean done) {
        this.done = done;
        return this;
    }
    
    public Boolean getFaulted() {
        return faulted;
    }
    
    public RequestStatusKobold setFaulted(Boolean faulted) {
        this.faulted = faulted;
        return this;
    }
    
    public Integer getWaitTime() {
        return waitTime;
    }
    
    public RequestStatusKobold setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
        return this;
    }
    
    public Integer getQueuePosition() {
        return queuePosition;
    }
    
    public RequestStatusKobold setQueuePosition(Integer queuePosition) {
        this.queuePosition = queuePosition;
        return this;
    }
    
    public Double getKudos() {
        return kudos;
    }
    
    public RequestStatusKobold setKudos(Double kudos) {
        this.kudos = kudos;
        return this;
    }
    
    public Boolean getIsPossible() {
        return isPossible;
    }
    
    public RequestStatusKobold setIsPossible(Boolean isPossible) {
        this.isPossible = isPossible;
        return this;
    }
    
    public List<GenerationKobold> getGenerations() {
        return generations;
    }
    
    public RequestStatusKobold setGenerations(List<GenerationKobold> generations) {
        this.generations = generations;
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
        return "RequestStatusKobold{" +
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
                ", generations=" + generations +
                '}';
    }
}
