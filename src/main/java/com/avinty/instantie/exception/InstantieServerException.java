package com.avinty.instantie.exception;

public class InstantieServerException extends Exception{
    /**
     * Default Serial ID
     */
    private static final long serialVersionUID = 345456L;

    /**
     * Default Constructor
     */
    public InstantieServerException() {

    }

    /**
     * Parameterized Constructor
     * @param message string
     */
    public InstantieServerException(String message) {
        super(message);
    }

    /**
     * Parameterized Constructor
     * @param cause throwable
     */
    public InstantieServerException(Throwable cause) {
        super(cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param cause throwable
     */
    public InstantieServerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param error error
     */
    public InstantieServerException(String message, Error error) {
        super(message, error);
    }
}
