package com.findbook.demo.dao;


import com.findbook.demo.entities.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderProducts, Long> {

}
