package com.everis.stockms.service;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.dto.SaveStockResponseDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNoContentException;

import java.util.List;

public interface StockService {
    FindByProductIdDto sumByProductId(Long productId) throws ResourceNoContentException;
    public List<Stock> save (List<Stock> stockList) throws BusinessException;
}
