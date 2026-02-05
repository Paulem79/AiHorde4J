package io.github.aihorde4j.client;

/**
 * Exception thrown when a Horde API operation fails.
 */
public class HordeException extends RuntimeException {
    
    private final int statusCode;
    private final String errorBody;
    
    public HordeException(String message) {
        super(message);
        this.statusCode = -1;
        this.errorBody = null;
    }
    
    public HordeException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = -1;
        this.errorBody = null;
    }
    
    public HordeException(String message, int statusCode, String errorBody) {
        super(message);
        this.statusCode = statusCode;
        this.errorBody = errorBody;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public String getErrorBody() {
        return errorBody;
    }
}
