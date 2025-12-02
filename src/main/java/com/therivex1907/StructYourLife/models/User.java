package com.therivex1907.StructYourLife.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.PrivateKey;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "structyourlife")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userId;
    @Email
    @NotBlank
    @Column(name = "email", unique = true)
    private String email;
    @NotNull
    private String password;
    @NotBlank
    @Column(name = "firstname", length = 50, nullable = false)
    private String firstName;
    @NotBlank
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleid")
    private Role role;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "companyname")
    private String companyName;
    @Column(name = "companyruc")
    private Integer companyRuc;
    @Column(name = "isactive")
    private Boolean isActive;
    @CreationTimestamp
    @Column(name = "createat")
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(name = "updateat")
    private LocalDateTime updateAt;
}
