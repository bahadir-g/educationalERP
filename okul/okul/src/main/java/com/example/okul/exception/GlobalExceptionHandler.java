package com.example.okul.exception;


import com.example.okul.response.ResponsePayload;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;
import java.util.Set;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException exception) {
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt bulunamadı.");
        return new ResponseEntity<>(responsePayload, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Mesaj okunamadı!");
        return new ResponseEntity<>(responsePayload,status);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Tip uyuşmazlığı!");
        return new ResponseEntity<>(responsePayload,status);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleInternalServerError(HttpServerErrorException.InternalServerError ex) {
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Internal Server Error");
        return new ResponseEntity<>(responsePayload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ TransactionSystemException.class })
    public ResponseEntity<Object> handleConstraintViolation(Exception ex) {
        Throwable cause = ((TransactionSystemException) ex).getRootCause();
        if (cause instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause).getConstraintViolations();
            String message = constraintViolations.stream().iterator().next().getMessageTemplate();
            ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), message);
            return new ResponseEntity<>(responsePayload, HttpStatus.NOT_ACCEPTABLE);
        }
        else
            { ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(),"TransactionSystem ex Message");
        return new ResponseEntity<>(responsePayload, HttpStatus.INTERNAL_SERVER_ERROR);}
    }
}
