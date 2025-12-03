package com.therivex1907.StructYourLife.services;

import com.therivex1907.StructYourLife.responses.BaseResponse;
import com.therivex1907.StructYourLife.responses.ProductResponse;
import com.therivex1907.StructYourLife.repositories.NativeQueryRepository;
import com.therivex1907.StructYourLife.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private NativeQueryRepository nativeQueryRepository;

    public BaseResponse<?> listProductsByParameters(Integer categoryId, Integer userId) {
        List<Object[]> data = nativeQueryRepository.listProductsByParameters(categoryId, userId);
        if (data.isEmpty()) {
            return new BaseResponse<>(404, "Data Not Found", null);
        }
        List<ProductResponse> products = new ArrayList<>();
        for (Object[] obj : data) {
            ProductResponse transformed = new ProductResponse();
            transformed.setCategoryId((Integer) obj[0]);
            transformed.setProductId((Integer) obj[1]);
            transformed.setUserId((Integer) obj[2]);
            transformed.setName((String) obj[3]);
            transformed.setStock((Integer) obj[4]);
            transformed.setPrice((Integer) obj[5]);
            products.add(transformed);
        }
        return new BaseResponse<>(200, "Ok", products);
    }
}
