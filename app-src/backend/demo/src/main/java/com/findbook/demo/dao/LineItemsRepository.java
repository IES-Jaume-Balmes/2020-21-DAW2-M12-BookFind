package com.findbook.demo.dao;

import com.findbook.demo.entities.LineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemsRepository extends JpaRepository<LineItems, Long> {
}
