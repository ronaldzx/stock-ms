package com.everis.stockms.service;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNoContentException;
import com.everis.stockms.repository.StockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
public class TestStockServiceShould {
    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @Test
    public void testSumByProductId() throws ResourceNoContentException {
        Integer total = 12;
        when(stockRepository.sumByProductId(any(Long.class))).thenReturn(total);
        FindByProductIdDto findByProductIdDto = new FindByProductIdDto();
        findByProductIdDto.setProductId(1L);
        findByProductIdDto.setTotal(total);
        FindByProductIdDto result = stockService.sumByProductId(1L);
        assertEquals(findByProductIdDto.getTotal(), result.getTotal());
    }

    @Test(expected = ResourceNoContentException.class)
    public void testSumByProductIdException() throws ResourceNoContentException {
        when(stockRepository.sumByProductId(any(Long.class))).thenReturn(null);
        stockService.sumByProductId(1L);
    }

    @Test
    public void testSave() throws BusinessException {
        List<Stock> saved = new ArrayList<>();
        Stock saved1 = new Stock();
        saved1.setId(1L);
        saved1.setProductId(1L);
        saved1.setWareHouseId(1L);
        saved1.setQuantity(1);
        Stock saved2 = new Stock();
        saved2.setId(1L);
        saved2.setProductId(2L);
        saved2.setWareHouseId(2L);
        saved2.setQuantity(2);
        saved.add(saved1);
        saved.add(saved2);

        List<Stock> stockList = new ArrayList<>();
        Stock stock1 = new Stock();
        stock1.setProductId(1L);
        stock1.setWareHouseId(1L);
        stock1.setQuantity(1);
        Stock stock2 = new Stock();
        stock2.setProductId(2L);
        stock2.setWareHouseId(2L);
        stock2.setQuantity(2);
        stockList.add(stock1);
        stockList.add(stock2);
        when(stockRepository.saveAll(any(ArrayList.class))).thenReturn(saved);
        List<Stock> result = stockService.save(stockList);

        assertEquals(saved.get(0).getProductId(), result.get(0).getProductId());
        assertEquals(saved.get(0).getQuantity(), result.get(0).getQuantity());
        assertEquals(saved.get(0).getWareHouseId(), result.get(0).getWareHouseId());
    }

    @Test(expected = BusinessException.class)
    public void testSaveException() throws BusinessException {
        List<Stock> stockList = new ArrayList<>();
        Stock stock1 = new Stock();
        stock1.setProductId(1L);
        stock1.setWareHouseId(1L);
        stock1.setQuantity(0);
        Stock stock2 = new Stock();
        stock2.setProductId(2L);
        stock2.setWareHouseId(2L);
        stock2.setQuantity(2);
        stockList.add(stock1);
        stockList.add(stock2);
//        when(stockRepository.saveAll(any(ArrayList.class))).thenReturn(saved);
        List<Stock> result = stockService.save(stockList);
    }
}
