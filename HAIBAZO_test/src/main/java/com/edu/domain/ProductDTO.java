package com.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductDTO {
	private Long productId;
	private String name;
    private String description;
    private Double price;
    private Double discount;
    private Integer quantity;
    private Double rating;
    
    private String categoryName;     
    private String styleName; 
    
    private List<String> sizeNames;  
    private List<String> imageURLs;
    private List<String> colorNames;
    
    public ProductDTO(Long productId2, String name2, String description2, Double price2, Double discount2,
			Integer quantity2, Double rating2, List<String> sizeNames2, List<String> imageURLs2,
			List<String> colorNames2, String categoryName2, String styleName2) {
		this.productId = productId2;
		this.name = name2;
		this.description = description2;
		this.price = price2;
		this.discount = discount2;
		this.quantity = quantity2;
		this.rating = rating2;
		this.sizeNames = sizeNames2;
		this.imageURLs = imageURLs2;
		this.colorNames = colorNames2;
		this.categoryName = categoryName2;
		this.styleName = styleName2;
	}
}

