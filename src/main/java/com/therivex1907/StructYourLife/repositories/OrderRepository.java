package com.therivex1907.StructYourLife.repositories;

import com.therivex1907.StructYourLife.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
