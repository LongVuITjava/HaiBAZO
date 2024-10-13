package com.edu.service;

import com.edu.domain.ProductDTO;
import java.util.List;
import java.util.Optional;

public interface ProductService {
	List<ProductDTO> findByColorsColorName(String colorName);

	List<ProductDTO> findBySizesSizeName(String sizeName);

	List<ProductDTO> findByPriceBetween(double minPrice, double maxPrice);

	Optional<ProductDTO> findProductById(Long id);

	List<ProductDTO> findAllProducts();

	List<ProductDTO> findByCategoryCategoryName(String categoryName);

	List<ProductDTO> findByStyleStyleName(String styleName);

	List<ProductDTO> findByFilter(String categoryName, double minPrice, double maxPrice, String styleName, String colorName,
			String sizeName);
}
