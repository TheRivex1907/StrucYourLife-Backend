package com.therivex1907.StructYourLife.services;

import com.therivex1907.StructYourLife.models.Category;
import com.therivex1907.StructYourLife.requests.CategoryRequest;
import com.therivex1907.StructYourLife.responses.BaseResponse;
import com.therivex1907.StructYourLife.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public BaseResponse<?> listAllCategories() {
        List<Category> data = categoryRepository.findAllByIsActive(true);
        if (data.isEmpty()) {
            return new BaseResponse<>(404, "No data founded", null);
        }
        return new BaseResponse<>(200, "Ok",  data);
    }

    public BaseResponse<?> createCategory(CategoryRequest categoryRequest) {
        Category newCategory = new Category();
        newCategory.setCategoryName(categoryRequest.getCategoryName());
        newCategory.setCategoryDescription(categoryRequest.getCategoryDescription());
        newCategory.setIsActive(true);
        newCategory.setCreatedDate(LocalDateTime.now());
        categoryRepository.save(newCategory);

        return new BaseResponse<>(200, "Ok", newCategory);
    }
}
