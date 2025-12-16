package com.therivex1907.StructYourLife.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orderitem", schema = "structyourlife")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitemid")
    private Integer orderItemId;
//    @ManyToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "orderid")
//    private Order order;
    @Column(name = "orderId")
    private Integer orderId;
    @Column(name = "productid")
    private Integer productId;
    private Integer quantity;
    private Double price;
}
