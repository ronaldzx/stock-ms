package com.everis.stockms.controller;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.dto.SaveStockRequestDto;
import com.everis.stockms.dto.SaveStockResponseDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNoContentException;
import com.everis.stockms.mapper.StockMapper;
import com.everis.stockms.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("stock/{productId}")
    public FindByProductIdDto stock(@PathVariable("productId") Long productId) throws ResourceNoContentException {
        return stockService.sumByProductId(productId);
    }

    @PostMapping("stock")
    public ResponseEntity<List<SaveStockResponseDto>> saveStock (@RequestBody List<SaveStockRequestDto> saveStockRequestDtoList) throws BusinessException {
        return new ResponseEntity<>(StockMapper.INSTANCE
                .toSaveStockResponseDto(stockService
                        .save(StockMapper.INSTANCE.toEntity(saveStockRequestDtoList))), HttpStatus.CREATED);
    }

}
