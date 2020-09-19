package com.everis.stockms.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.dto.SaveStockRequestDto;
import com.everis.stockms.dto.SaveStockResponseDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNoContentException;
import com.everis.stockms.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestStockControllerShould {
    @InjectMocks
    private StockController stockController;
    @Mock
    private StockService service;

    @Test
    public void testCountByProductid() throws ResourceNoContentException {
        FindByProductIdDto findByProductIdDto = new FindByProductIdDto();
        findByProductIdDto.setProductId(1L);
        findByProductIdDto.setTotal(10);

        when(service.sumByProductId(any(Long.class))).thenReturn(findByProductIdDto);

        FindByProductIdDto result = stockController.stock(1L);
        assertEquals(findByProductIdDto.getProductId(),result.getProductId());
        assertEquals(findByProductIdDto.getTotal(),result.getTotal());
    }
    @Test
    public void testSaveStock() throws BusinessException{
        Stock stock1 = new Stock();
        stock1.setId(1L);
        stock1.setProductId(1L);
        stock1.setWareHouseId(1L);
        stock1.setQuantity(1);
        Stock stock2 = new Stock();
        stock2.setId(2L);
        stock2.setProductId(2L);
        stock2.setWareHouseId(2L);
        stock2.setQuantity(2);
        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock1);
        stockList.add(stock2);
        when(service.save(any(ArrayList.class))).thenReturn(stockList);

        SaveStockRequestDto saveStockRequestDto1 = new SaveStockRequestDto();
        saveStockRequestDto1.setProductId(1L);
        saveStockRequestDto1.setWareHouseId(1L);
        saveStockRequestDto1.setQuantity(1);
        SaveStockRequestDto saveStockRequestDto2 = new SaveStockRequestDto();
        saveStockRequestDto2.setProductId(2L);
        saveStockRequestDto2.setWareHouseId(2L);
        saveStockRequestDto2.setQuantity(2);
        List<SaveStockRequestDto> saveStockRequestDtoList = new ArrayList<>();
        saveStockRequestDtoList.add(saveStockRequestDto1);
        saveStockRequestDtoList.add(saveStockRequestDto2);

        ResponseEntity<List<SaveStockResponseDto>> result = stockController.saveStock(saveStockRequestDtoList);

        assertNotNull(result);
        assertEquals(saveStockRequestDtoList.size() ,result.getBody().size());
        assertEquals(saveStockRequestDto1.getProductId(),result.getBody().get(0).getProductId());
        assertEquals(saveStockRequestDto2.getProductId(),result.getBody().get(1).getProductId());
        assertEquals(saveStockRequestDto2.getQuantity(),result.getBody().get(1).getQuantity());
        assertEquals(saveStockRequestDto2.getWareHouseId(),result.getBody().get(1).getWareHouseId());
        assertEquals(2L,result.getBody().get(1).getId());

    }
}
