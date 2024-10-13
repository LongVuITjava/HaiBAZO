package com.edu.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Double discount;
    private Integer quantity;
    private Double rating; 

    private String categoryName;
    private String styleName;
    
    private List<String> imageUrls;
    private List<String> sizeName;
    private List<String> colorName;
}
