package com.everis.stockms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindByProductIdDto {
    private Long productId;
    private Integer total;
}
