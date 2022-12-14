package com.devsuperior.dsmeta.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.domain.dto.SaleDTO;
import com.devsuperior.dsmeta.domain.entity.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sale")
public class SaleResource {

	@Autowired
	private SaleService saleService;

	@Autowired
	private SmsService smsService;
	
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable){
		Page<Sale> sales = saleService.findSales(minDate, maxDate, pageable);
		Page<SaleDTO> salesDTO = sales.map(obj -> new SaleDTO(obj));
		return ResponseEntity.ok().body(salesDTO);
		
	}
	
	
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
	
	@GetMapping("/seller")
	public ResponseEntity<Page<SaleDTO>> searchSeller(
			@RequestParam(value="searchSeller") String searchSeller,
			@RequestParam(value="page", required = false, defaultValue = "0") int page,
			@RequestParam(value="size", required = false, defaultValue = "10") int size){
		
		Page<Sale> sales = saleService.searchSeller(searchSeller, page, size);
		Page<SaleDTO> salesDTO = sales.map(obj -> new SaleDTO(obj));
		
		return ResponseEntity.ok().body(salesDTO); 
	}
	
	@GetMapping("/sms/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
