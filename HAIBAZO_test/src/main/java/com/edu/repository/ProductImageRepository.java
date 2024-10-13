package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.model.ProductImage;


public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    
}
