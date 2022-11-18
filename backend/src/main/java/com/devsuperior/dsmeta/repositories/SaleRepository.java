package com.devsuperior.dsmeta.repositories;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.dsmeta.domain.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("FROM Sale s " + 
			"WHERE LOWER (s.sellerName) LIKE %:searchSeller% ")
	Page<Sale> searchSeller(@Param("searchSeller") String seller, Pageable pageable);
	
	@Query("SELECT obj FROM Sale obj " +
		   " WHERE obj.date BETWEEN :minDate AND :maxDate ORDER BY obj.amount DESC ")
	Page<Sale> findSales(LocalDate minDate, LocalDate maxDate, Pageable pageable);

}
