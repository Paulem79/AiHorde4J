package net.paulem.aihorde4j.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from async generation request containing the request ID.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestAsync {
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("kudos")
    private Double kudos;
    
    public RequestAsync() {
    }
    
    public String getId() {
        return id;
    }
    
    public RequestAsync setId(String id) {
        this.id = id;
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public RequestAsync setMessage(String message) {
        this.message = message;
        return this;
    }
    
    public Double getKudos() {
        return kudos;
    }
    
    public RequestAsync setKudos(Double kudos) {
        this.kudos = kudos;
        return this;
    }
    
    @Override
    public String toString() {
        return "RequestAsync{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", kudos=" + kudos +
                '}';
    }
}
