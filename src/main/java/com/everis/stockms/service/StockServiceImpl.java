package com.everis.stockms.service;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNoContentException;
import com.everis.stockms.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public FindByProductIdDto sumByProductId(Long productId) throws ResourceNoContentException {
        Integer total = stockRepository.sumByProductId(productId);
        if (total == null) {
            throw new ResourceNoContentException();
        }
        FindByProductIdDto result = new FindByProductIdDto();
        result.setTotal(total);
        result.setProductId(productId);
        return result;
    }
    @Override
    public List<Stock> save(List<Stock> stockList) throws BusinessException {
        for (Stock stock : stockList) {
            if (stock.getQuantity().equals(0)) {
                throw new BusinessException("Quantity of product cannot be 0");
            }
        }
        return stockRepository.saveAll(stockList);
    }
}
