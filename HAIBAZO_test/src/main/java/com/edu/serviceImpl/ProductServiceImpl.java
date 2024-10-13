package com.edu.serviceImpl;

import com.edu.domain.ProductDTO;
import com.edu.model.Product;
import com.edu.repository.ProductRepository;
import com.edu.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Chuyển từ Product sang ProductDTO
	private ProductDTO convertToDTO(Product product) {
	    // Lấy danh sách sizeNames
	    List<String> sizeNames = product.getSizes().stream()
	            .map(size -> size.getSizeName()) 
	            .collect(Collectors.toList());

	    // Lấy danh sách imageURLs
	    List<String> imageURLs = product.getProductImages().stream()
	            .map(image -> image.getImageUrl())  
	            .collect(Collectors.toList());

	    // Lấy danh sách colorNames
	    List<String> colorNames = product.getColors().stream()
	            .map(color -> color.getColorName()) 
	            .collect(Collectors.toList());

	    return new ProductDTO(
	            product.getProductId(),
	            product.getName(),
	            product.getDescription(),
	            product.getPrice(),
	            product.getDiscount(),
	            product.getQuantity(),
	            product.getRating(),
	            sizeNames,     
	            imageURLs,   
	            colorNames,    
	            product.getCategoryName(),   
	            product.getStyleName()      
	    );
	}


	@Override
	public List<ProductDTO> findAllProducts() {
		return productRepository.findAll().stream().map(this::convertToDTO) // Chuyển từng Product sang ProductDTO
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ProductDTO> findProductById(Long id) {
		return productRepository.findById(id).map(this::convertToDTO); 
	}

	@Override
	public List<ProductDTO> findByCategoryCategoryName(String categoryName) {
	    List<Product> products = productRepository.findByCategoryCategoryName(categoryName);
	    return products.stream()
	            .map(this::convertToDTO)  // Chuyển đổi từng Product sang ProductDTO
	            .collect(Collectors.toList());
	}


	@Override
	public List<ProductDTO> findByPriceBetween(double minPrice, double maxPrice) {
	    List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
	    return products.stream()
	            .map(this::convertToDTO)  
	            .collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> findByStyleStyleName(String styleName) {
	    List<Product> products = productRepository.findByStyleStyleName(styleName);
	    return products.stream()
	            .map(this::convertToDTO) 
	            .collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> findBySizesSizeName(String sizeName) {
	    List<Product> products = productRepository.findBySizesSizeName(sizeName);
	    return products.stream()
	            .map(this::convertToDTO)
	            .collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> findByColorsColorName(String colorName) {
	    List<Product> products = productRepository.findByColorsColorName(colorName);
	    return products.stream()
	            .map(this::convertToDTO) 
	            .collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> findByFilter(String categoryName, double minPrice, double maxPrice, String styleName, String colorName, String sizeName) {
	    List<Product> products = productRepository.findByCategoryCategoryNameAndPriceBetweenAndStyleStyleNameAndColorsColorNameAndSizesSizeName(
	        categoryName, minPrice, maxPrice, styleName, colorName, sizeName);
	    return products.stream()
	            .map(this::convertToDTO)
	            .collect(Collectors.toList());
	}


}
