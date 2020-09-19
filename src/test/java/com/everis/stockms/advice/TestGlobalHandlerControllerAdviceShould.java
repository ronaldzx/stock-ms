package com.everis.stockms.advice;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.everis.stockms.controller.advice.GlobalHandlerControllerAdvice;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNoContentException;
import com.everis.stockms.utils.ErrorDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class TestGlobalHandlerControllerAdviceShould {
    @InjectMocks
    private GlobalHandlerControllerAdvice handler;

    @Test
    public void testBusinessException(){
        BusinessException exception = new BusinessException("error");
        ResponseEntity<ErrorDetail> result = handler.businessException(exception);
        assertNotNull(result);
        assertEquals(exception.getMessage(),result.getBody().getMessage());
        assertEquals(exception.getDate(),result.getBody().getDate());
    }
    @Test
    public void testResourceNoContentException(){
        assertNotNull(handler.resourceNoContentException(new ResourceNoContentException()));
    }
}
