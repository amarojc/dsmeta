package com.devsuperior.dsmeta.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.domain.dto.SaleDTO;
import com.devsuperior.dsmeta.domain.entity.Sale;
import com.devsuperior.dsmeta.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@GetMapping()
	public ResponseEntity<List<SaleDTO>> findAll(){
		List<Sale> sales = saleService.findAllSales();
		List<SaleDTO> salesDTO = sales.parallelStream()
				.map(obj -> new SaleDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(salesDTO); 
	}
}
