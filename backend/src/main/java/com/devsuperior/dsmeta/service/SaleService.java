package com.devsuperior.dsmeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.domain.entity.Sale;
import com.devsuperior.dsmeta.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findAllSales() {
		List<Sale> sales = saleRepository.findAll();
		return sales;
	}
}
