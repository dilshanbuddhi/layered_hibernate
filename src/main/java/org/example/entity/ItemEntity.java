package org.example.entity;

import com.mysql.cj.util.DnsSrv;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class ItemEntity {
    @Id
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnhand;

    @ManyToMany
    private List<OrderEntity> order;

    public ItemEntity(String code, String description, double unitPrice, int qtyOnhand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnhand = qtyOnhand;
    }
}
