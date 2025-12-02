package com.therivex1907.StructYourLife.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category", schema = "structyourlife")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private Integer categoryId;
    @NotBlank
    @Column(name = "name", length = 50)
    private String categoryName;
    @NotBlank
    @Column(name = "description", length = 250)
    private String categoryDescription;
    @Column(name = "isactive")
    private Boolean isActive;
    @CreationTimestamp
    @Column(name = "createat", updatable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    @Column(name = "updateat")
    private LocalDateTime updatedDate;
}
