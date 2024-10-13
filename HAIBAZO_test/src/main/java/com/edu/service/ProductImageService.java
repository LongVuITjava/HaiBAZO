package com.edu.service;


import com.edu.model.ProductImage;

public interface ProductImageService {

	void deleteProductImage(Long imageId);

	ProductImage saveProductImage(ProductImage productImage);

}
