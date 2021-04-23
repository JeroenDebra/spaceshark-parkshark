package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.customExeptions.CategoryNotValidException;
import com.switchfully.spaceshark.customExeptions.CurrencyNotValidException;
import com.switchfully.spaceshark.customExeptions.NotAuthorizedException;
import com.switchfully.spaceshark.model.parkingLot.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException{
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    public void handleIllegalState(IllegalStateException exception, HttpServletResponse response) throws IOException{
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public void handleNotAuthorized(NotAuthorizedException exception, HttpServletResponse response) throws IOException{
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
    }

    @ExceptionHandler(CategoryNotValidException.class)
    public void handleInvalidCategory(CategoryNotValidException exception, HttpServletResponse response) throws IOException{
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(CurrencyNotValidException.class)
    public void handleInvalidcurrency(CurrencyNotValidException exception, HttpServletResponse response) throws IOException{
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }


}
