package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.domain.entity.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;


	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? (today.minusDays(365)) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return saleRepository.findSales(min, max, pageable);
	}
	
	public Page<Sale> findAll(Pageable pageable) {
		Page<Sale> sales = saleRepository.findAll(pageable);
		return sales;
	}
	
	public Page<Sale> findAllSales() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "sellerName");
		return new PageImpl<>(saleRepository.findAll(), pageRequest, size);
	}
	
	public Page<Sale> searchSeller(String seller, int page, int size){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "date");
		return saleRepository.searchSeller(seller.toLowerCase(), pageRequest);
	}
}
