package net.paulem.aihorde4j.exception;

/**
 * Exception thrown when the API returns an error response.
 */
public class AiHordeApiException extends AiHordeException {
    private final int statusCode;

    public AiHordeApiException(String message, String errorCode, int statusCode) {
        super(message, errorCode);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
