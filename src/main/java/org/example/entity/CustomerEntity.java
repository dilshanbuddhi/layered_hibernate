package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class CustomerEntity {
    @Id
    private String ID;
    private String name;
    private String address;
    private int teli;



/*    @ManyToOne
    private OrderEntity orderEntity;*/

    public CustomerEntity(String ID, String name, String address, int teli) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.teli = teli;
    }

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orderEntityList = new ArrayList<>();

    public CustomerEntity() {

    }
}
