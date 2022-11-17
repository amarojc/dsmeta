package com.devsuperior.dsmeta.domain.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.domain.entity.Sale;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SaleDTO {
	
	private Long id;
	private String sellerName;
	private Integer visited;
	private Integer deals;
	private Double amount;
	@JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR")
	private LocalDate date;
	
	
	public SaleDTO(Sale sale) {
		super();
		this.id = sale.getId();
		this.sellerName = sale.getSellerName();
		this.visited = sale.getVisited();
		this.deals = sale.getDeals();
		this.amount = sale.getAmount();
		this.date = sale.getDate();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Integer getVisited() {
		return visited;
	}
	public void setVisited(Integer visited) {
		this.visited = visited;
	}
	public Integer getDeals() {
		return deals;
	}
	public void setDeals(Integer deals) {
		this.deals = deals;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
}
