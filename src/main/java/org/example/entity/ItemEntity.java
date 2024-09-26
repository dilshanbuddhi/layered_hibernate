package org.example.entity;

import com.mysql.cj.util.DnsSrv;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class ItemEntity {
    @Id
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnhand;
}
