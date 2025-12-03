package com.therivex1907.StructYourLife.repositories;

import com.therivex1907.StructYourLife.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
