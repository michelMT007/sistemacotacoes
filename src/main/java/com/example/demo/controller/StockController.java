package com.example.demo.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.StockDTO;
import com.example.demo.service.StockService;

//import java.time.LocalDate;
//import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value="/stock")
public class StockController {

	@Autowired 
	private StockService service;
	
	@GetMapping
	public ResponseEntity<String> hello(){
		return ResponseEntity.ok().body("HELLO-WORLD");
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
		
		return ResponseEntity.ok(service.save(dto));
		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto){
		
		return ResponseEntity.ok(service.update(dto));
		
		
	}
	
	@GetMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id ){
		 
		
		return ResponseEntity.ok(service.findById(id));

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){
		
		return ResponseEntity.ok(service.findAll());
		
	}
	
	@DeleteMapping(value ="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> delete(@PathVariable Long id) {
		
		 return ResponseEntity.ok(service.delete(id));
	}
	
	
}
