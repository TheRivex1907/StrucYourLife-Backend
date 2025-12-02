package com.therivex1907.StructYourLife.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Role {
    @Id
    @Column(name = "roleid")
    private Integer roleId;
    private String name;
    @Column(name = "isactive")
    private Boolean isActive;
}
