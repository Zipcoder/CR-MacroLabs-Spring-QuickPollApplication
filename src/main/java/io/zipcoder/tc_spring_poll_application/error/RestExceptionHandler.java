package io.zipcoder.tc_spring_poll_application.error;

import io.zipcoder.tc_spring_poll_application.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * project: spring-demo
 * package: io.zipcoder.tc_spring_poll_application.error
 * author: https://github.com/vvmk
 * date: 4/7/18
 */
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe,
                                                             HttpServletRequest request) {
        ErrorDetail err = new ErrorDetail();
        err.setTimestamp(new Date().getTime());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setDetail(rnfe.getMessage());
        err.setDeveloperMessage(Arrays.toString(rnfe.getStackTrace()));
        err.setTitle(rnfe.getClass().toString());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
