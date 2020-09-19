package com.everis.stockms.repository;

import com.everis.stockms.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("Select sum(s.quantity) from Stock s where s.productId = ?1")
    Integer sumByProductId(Long productId);

}
