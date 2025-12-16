package com.therivex1907.StructYourLife.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NativeQueryRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Object[]> listProductsByParameters(Integer categoryId, Integer userId) {
        String sql = "SELECT * FROM structyourlife.listProductsByParameters(:categoryId, :userId)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("categoryId", categoryId);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Transactional
    public List<Object[]> listOrdersByParameters(Integer categoryId, Integer userId, Integer state) {
        String sql = "SELECT * FROM structyourlife.listOrdersByParameters(:categoryId, :userId, :state)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("categoryId", categoryId);
        query.setParameter("userId", userId);
        query.setParameter("state", state);
        return query.getResultList();
    }
}
