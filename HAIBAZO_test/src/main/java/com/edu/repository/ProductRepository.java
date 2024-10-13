package com.edu.repository;

import com.edu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Lọc theo category
	List<Product> findByCategoryCategoryName(String categoryName);

    // Lọc theo khoảng giá
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Lọc theo style
    List<Product> findByStyleStyleName(String styleName);

    // Lọc theo color
    List<Product> findByColorsColorName(String colorName);
    
 // Lọc theo size
    List<Product> findBySizesSizeName(String sizeName);

    // Lọc kết hợp nhiều tiêu chí
    List<Product> findByCategoryCategoryNameAndPriceBetweenAndStyleStyleNameAndColorsColorNameAndSizesSizeName(String categoryName,
    		double minPrice, double maxPrice, String styleName, String colorName, String sizeName);
}
