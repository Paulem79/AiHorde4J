package net.paulem.aihorde4j.exception;

/**
 * Base exception for all AiHorde4J errors.
 */
public class AiHordeException extends RuntimeException {
    private final String errorCode;

    public AiHordeException(String message) {
        super(message);
        this.errorCode = null;
    }

    public AiHordeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public AiHordeException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
