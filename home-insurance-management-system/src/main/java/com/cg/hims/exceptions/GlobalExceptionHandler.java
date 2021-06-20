package com.cg.hims.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AgentNotFoundException.class)
    public ResponseEntity<?> agentNotFoundException(AgentNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    	}
         @ExceptionHandler(PolicyHolderNotFoundException.class)
         public ResponseEntity<?> policyHolderNotFoundException(PolicyHolderNotFoundException ex, WebRequest request) {
              ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
              return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
         }
         
         @ExceptionHandler(QuoteNotFoundException.class)
         public ResponseEntity<?> quoteNotFoundException(QuoteNotFoundException ex, WebRequest request) {
              ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
              return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
         }
         
//         @ExceptionHandler(InvalidCredentialException.class)
//         public ResponseEntity<?> invalidCredentialException(InvalidCredentialException ex, WebRequest request) {
//              ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//              return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//         }
         
         @ExceptionHandler(PolicyNotFoundException.class)
         public ResponseEntity<?> PolicyNotFoundException(PolicyNotFoundException ex, WebRequest request) {
              ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
              return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
         }
         @ExceptionHandler(MethodArgumentNotValidException.class)
         public Map<String, String> handleValidationExceptions(
           MethodArgumentNotValidException ex) {
             Map<String, String> errors = new HashMap<>();
             ex.getBindingResult().getAllErrors().forEach((error) -> {
                 String fieldName = ((FieldError) error).getField();
                 String errorMessage = error.getDefaultMessage();
                 errors.put(fieldName, errorMessage);
             });
             return errors;
         }
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }  
}