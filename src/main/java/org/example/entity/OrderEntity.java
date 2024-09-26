package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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


/*    @OneToMany (mappedBy = "customerentity")
    private List<OrderEntity>orderEntities;*/
}
