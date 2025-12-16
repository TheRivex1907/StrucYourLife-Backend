package com.therivex1907.StructYourLife.repositories;

import com.therivex1907.StructYourLife.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByIsActive(Boolean active);
}
