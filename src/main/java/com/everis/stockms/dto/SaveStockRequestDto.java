package com.everis.stockms.dto;

import com.everis.stockms.entity.Stock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SaveStockRequestDto {
    private Long productId;
    private Long wareHouseId;
    private Integer quantity;
}
