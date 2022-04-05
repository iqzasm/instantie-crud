package com.avinty.instantie.exception;

public class InstantieException extends RuntimeException{
    /**
     * Default Serial ID
     */
    private static final long serialVersionUID = 345456L;

    /**
     * Default Constructor
     */
    public InstantieException() {

    }

    /**
     * Parameterized Constructor
     * @param message string
     */
    public InstantieException(String message) {
        super(message);
    }

    /**
     * Parameterized Constructor
     * @param cause throwable
     */
    public InstantieException(Throwable cause) {
        super(cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param cause throwable
     */
    public InstantieException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param error error
     */
    public InstantieException(String message, Error error) {
        super(message, error);
    }
}
