package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.pojo.Orders;

public interface OrderDao extends JpaRepository<Orders, Long> {

	@Query("select o from Orders o where o.createdOn BETWEEN: startDate AND :endDate")
	List<Orders>findOrdersWithInPeriod(@Param("startDate") LocalDate startDate,@Param("endtDate") LocalDate endDate);
}
