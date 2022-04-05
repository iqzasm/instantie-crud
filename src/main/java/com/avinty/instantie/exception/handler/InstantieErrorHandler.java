package com.avinty.instantie.exception.handler;

import com.avinty.instantie.exception.InstantieException;
import com.avinty.instantie.exception.InstantieServerException;
import com.avinty.instantie.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * Error Handle Controller Advice
 */
@ControllerAdvice
@Slf4j
public class InstantieErrorHandler {

    /**
     * Exception Handling Not Found Method
     * @param req httpservlet req
     * @param ie Instantie custom exception
     * @return Error Response
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InstantieException.class)
    @ResponseBody
    public ErrorResponse handleInstantieException(HttpServletRequest req, InstantieException ie) {
        log.info("InstantieException {}", ie.getMessage());
        return ErrorResponse.builder().status(HttpStatus.NOT_FOUND.value()).message(HttpStatus.NOT_FOUND.getReasonPhrase()).details(ie.getMessage()).build();
    }

    /**
     * Exception Handling Internal Server Error Method
     * @param ise instantie server customer exception
     * @return Error Response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InstantieServerException.class)
    @ResponseBody
    public ErrorResponse handleInstantieServerException(InstantieServerException ise) {
        log.info("InstantieServerException {}", ise.getMessage());
        return ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).details(ise.getMessage()).build();
    }

    /**
     * Exception Handling Internal Server error
     * @param ex Exception
     * @return Error Response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse handleException(Exception ex) {
        log.info("Exception {}", ex.getMessage());
        return ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).details(ex.getMessage()).build();
    }

}
