package io.github.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Response containing the final status and results of a Stable Diffusion generation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestStatusStable {
    
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
    private List<Generation> generations;
    
    @JsonProperty("shared")
    private Boolean shared;
    
    public RequestStatusStable() {
    }
    
    public Integer getFinished() {
        return finished;
    }
    
    public RequestStatusStable setFinished(Integer finished) {
        this.finished = finished;
        return this;
    }
    
    public Integer getProcessing() {
        return processing;
    }
    
    public RequestStatusStable setProcessing(Integer processing) {
        this.processing = processing;
        return this;
    }
    
    public Integer getRestarted() {
        return restarted;
    }
    
    public RequestStatusStable setRestarted(Integer restarted) {
        this.restarted = restarted;
        return this;
    }
    
    public Integer getWaiting() {
        return waiting;
    }
    
    public RequestStatusStable setWaiting(Integer waiting) {
        this.waiting = waiting;
        return this;
    }
    
    public Boolean getDone() {
        return done;
    }
    
    public RequestStatusStable setDone(Boolean done) {
        this.done = done;
        return this;
    }
    
    public Boolean getFaulted() {
        return faulted;
    }
    
    public RequestStatusStable setFaulted(Boolean faulted) {
        this.faulted = faulted;
        return this;
    }
    
    public Integer getWaitTime() {
        return waitTime;
    }
    
    public RequestStatusStable setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
        return this;
    }
    
    public Integer getQueuePosition() {
        return queuePosition;
    }
    
    public RequestStatusStable setQueuePosition(Integer queuePosition) {
        this.queuePosition = queuePosition;
        return this;
    }
    
    public Double getKudos() {
        return kudos;
    }
    
    public RequestStatusStable setKudos(Double kudos) {
        this.kudos = kudos;
        return this;
    }
    
    public Boolean getIsPossible() {
        return isPossible;
    }
    
    public RequestStatusStable setIsPossible(Boolean isPossible) {
        this.isPossible = isPossible;
        return this;
    }
    
    public List<Generation> getGenerations() {
        return generations;
    }
    
    public RequestStatusStable setGenerations(List<Generation> generations) {
        this.generations = generations;
        return this;
    }
    
    public Boolean getShared() {
        return shared;
    }
    
    public RequestStatusStable setShared(Boolean shared) {
        this.shared = shared;
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
        return "RequestStatusStable{" +
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
                ", shared=" + shared +
                '}';
    }
}
