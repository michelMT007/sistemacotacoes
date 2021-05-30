package com.example.demo.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.swing.DefaultRowSorter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundExeption;
import com.example.demo.mapper.StockMapper;
import com.example.demo.model.StockDTO;
import com.example.demo.modelo.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.util.MessageUtils;

@Service
public class StockService {
	
	@Autowired
	private StockRepository repository;
	
	@Autowired
	private StockMapper mapper; 
	
	@Transactional
	public StockDTO save(StockDTO dto) {
		// TODO Auto-generated method stub
		Optional<Stock> optionalstock = repository.findByNameAndDate(dto.getName(), dto.getDate());	
		if(optionalstock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDto(stock);
	}
	

	@Transactional
	public StockDTO update(StockDTO dto) {
		// TODO Auto-generated method stub
		Optional<Stock> optionalstock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());	
		if(optionalstock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDto(stock);
	}

	@Transactional(readOnly=true)
	public List<StockDTO> findAll() {
		// TODO Auto-generated method stub
		List<Stock> list = repository.findAll();
		return mapper.toDto(list);
	}

	@Transactional(readOnly=true)
	public StockDTO findById(Long id) {
		// TODO Auto-generated method stub
		
		return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundExeption::new);
	}

	@Transactional
	public StockDTO delete(Long id) {
		// primeiro ver se tem este id no banco de dados com o findBy Id
		StockDTO dto = this.findById(id);
		repository.deleteById(dto.getId()); 
		return dto;
	}
	@Transactional(readOnly = true)
	public List<StockDTO> findByToday(){
		return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundExeption::new);
	}
	
	
}
