package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
public class OrderEntity {
    @Id
    private String id;
    private double prize;



    private int qty;
    @ManyToOne
    private CustomerEntity customer;

    @ManyToMany (mappedBy = "order")
    private List<ItemEntity> itemEntities;

    public OrderEntity(String id, double prize, int qty, CustomerEntity customer) {
        this.id = id;
        this.prize = prize;
        this.qty = qty;
        this.customer = customer;
    }

/*    @OneToMany (mappedBy = "customerentity")
    private List<OrderEntity>orderEntities;*/
}
