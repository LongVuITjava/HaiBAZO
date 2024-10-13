package com.edu.serviceImpl;

import com.edu.model.ProductImage;
import com.edu.repository.ProductImageRepository;
import com.edu.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public ProductImage saveProductImage(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public void deleteProductImage(Long imageId) {
        productImageRepository.deleteById(imageId);
    }
}
