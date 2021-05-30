package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.example.demo.model.StockDTO;
import com.example.demo.modelo.*;


@Component
public class StockMapper {

	public Stock toEntity(@Valid StockDTO dto) {
		// TODO Auto-generated method stub
		Stock stock = new Stock();
		stock.setName(dto.getName());
		stock.setDate(dto.getDate());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		stock.setId(dto.getId());
		
		return stock;
	}
	
	public StockDTO toDto(Stock stock) {
		
		StockDTO dto = new StockDTO();
		dto.setName(stock.getName());
		dto.setDate(stock.getDate());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		dto.setId(stock.getId());
		
		return dto;
	}

	public List<StockDTO> toDto(List<Stock> liststock) {
		// TODO Auto-generated method stub
		return liststock.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
