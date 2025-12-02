package com.therivex1907.StructYourLife.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product", schema = "structyourlife")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productId;
    @NotBlank
    @Column(length = 100)
    private String name;
    @NotNull
    @Positive
    private Integer stock;
    @NotNull
    @Positive
    private Integer price;
    @CreationTimestamp
    @Column(name = "createat",updatable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    @Column(name = "updateat")
    private LocalDateTime updatedDate;
    @Column(name = "isactive")
    private Boolean isActive;
}
