package quickpoll.io.zipcoder.tc_spring_poll_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import quickpoll.dtos.error.ErrorDetail;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe, HttpServletRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("Resource Not Found");
        errorDetail.setStatus(404);
        errorDetail.setDetail(rnfe.getMessage());
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setDeveloperMessage(rnfe.getStackTrace().toString());

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
}
