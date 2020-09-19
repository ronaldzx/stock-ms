package com.everis.stockms.controller.advice;

import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNoContentException;
import com.everis.stockms.utils.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerControllerAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDetail> businessException(BusinessException businessException){
        return new ResponseEntity<>(new ErrorDetail(businessException.getMessage(),businessException.getDate()),
                HttpStatus.OK);
    }
    @ExceptionHandler(ResourceNoContentException.class)
    public ResponseEntity<?> resourceNoContentException(ResourceNoContentException resourceNoContentException){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
