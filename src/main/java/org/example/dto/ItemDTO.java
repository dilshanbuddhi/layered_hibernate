package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data
public class ItemDTO {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnhand;
}
