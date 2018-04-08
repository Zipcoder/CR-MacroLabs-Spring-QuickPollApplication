package io.zipcoder.tc_spring_poll_application.exception;

import io.zipcoder.tc_spring_poll_application.dto.error.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe, HttpServletRequest request) {
        ErrorDetail customError = new ErrorDetail();
        customError.setDetail(rnfe.getMessage());
        customError.setDeveloperMessage(rnfe.getStackTrace().toString());
        customError.setStatus(404);
        customError.setTimeStamp(new Date().getTime());
        customError.setTitle("Resource Not Found");

        return new ResponseEntity<>(customError, null, HttpStatus.NOT_FOUND);
    }
}


//Create RestExceptionHandler class annotated with @ControllerAdvice
//Create a handler method with the header shown below
// Populate an ErrorDetail object in the method, and
//return a ResponseEntity containing the ErrorDetail and an HTTP NOT_FOUND status
//Use java.util's new Date().getTime() for the timestamp
//Provide the detail and developer messages from the ResourceNotFoundException
