package com.therivex1907.StructYourLife.services;

import com.therivex1907.StructYourLife.models.Role;
import com.therivex1907.StructYourLife.repositories.RoleRepository;
import com.therivex1907.StructYourLife.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public BaseResponse<?> listActiveRoles() {
        List<Role> data = roleRepository.findByIsActive(true);
        if (data.isEmpty()) {
            return new BaseResponse<>(404, "Data not founded", null);
        }
        return new BaseResponse<>(200, "Ok", null);
    }
}
