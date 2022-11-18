package com.devsuperior.dsmeta.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.domain.dto.SaleDTO;
import com.devsuperior.dsmeta.domain.entity.Sale;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleResource {

	@Autowired
	private SaleService saleService;
	
	@GetMapping("/sales")
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<Sale> sales = saleService.findAll(pageable);
		Page<SaleDTO> salesDTO = sales.map(obj -> new SaleDTO(obj));
		return ResponseEntity.ok().body(salesDTO); 
	}
	
	@GetMapping("/saless")
	public ResponseEntity<Page<SaleDTO>> findAllSales(){
		Page<Sale> sales = saleService.findAllSales();
		Page<SaleDTO> salesDTO = sales.map(obj -> new SaleDTO(obj));
		return ResponseEntity.ok().body(salesDTO);
	}
}
