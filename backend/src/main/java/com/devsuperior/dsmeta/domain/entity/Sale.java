package com.devsuperior.dsmeta.domain.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.devsuperior.dsmeta.domain.dto.SaleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_sales")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="seller_name")
	private String sellerName;
	private Integer visited;
	private Integer deals;
	private Double amount;
	@JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR")
	private LocalDate date;
	
	
	public Sale(SaleDTO saleDTO) {
		super();
		this.id = saleDTO.getId();
		this.sellerName = saleDTO.getSellerName();
		this.visited = saleDTO.getVisited();
		this.deals = saleDTO.getDeals();
		this.amount = saleDTO.getAmount();
		this.date = saleDTO.getDate();
	}
	
	
	public Sale() {
		
	}
	
	
	public Sale(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDate date) {
		super();
		this.id = id;
		this.sellerName = sellerName;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sale [id=");
		builder.append(id);
		builder.append(", sellerName=");
		builder.append(sellerName);
		builder.append(", visited=");
		builder.append(visited);
		builder.append(", deals=");
		builder.append(deals);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
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
