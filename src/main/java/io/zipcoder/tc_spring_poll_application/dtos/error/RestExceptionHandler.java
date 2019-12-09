package io.zipcoder.tc_spring_poll_application.dtos.error;

import io.zipcoder.tc_spring_poll_application.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setDeveloperMessage(rnfe.getMessage());
        errorDetail.setDetail(Arrays.toString(rnfe.getStackTrace()));
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }


}
