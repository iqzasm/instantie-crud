package com.avinty.instantie.exception;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ErrorResponse {

    /**
     * Property HTTP Status Error Code
     */
    private int status;

    /**
     * Property Error Message
     */
    private String message;

    /**
     * Property Detailed Message
     */
    private String details;
}