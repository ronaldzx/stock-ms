package com.everis.stockms.mapper;

import com.everis.stockms.dto.SaveStockRequestDto;
import com.everis.stockms.dto.SaveStockResponseDto;
import com.everis.stockms.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    public SaveStockResponseDto map (Stock stock);
    public List<SaveStockResponseDto> toSaveStockResponseDto(List<Stock> stocks);

    public Stock map(SaveStockRequestDto saveStockRequestDto);
    public List<Stock> toEntity(List<SaveStockRequestDto> saveStockRequestDtoList);

}
