package com.therivex1907.StructYourLife.repositories;

import com.therivex1907.StructYourLife.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByIsActive(Boolean isActive);
}
