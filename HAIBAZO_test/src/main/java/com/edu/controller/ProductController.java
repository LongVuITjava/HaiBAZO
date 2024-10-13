package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.domain.ProductDTO;
import com.edu.model.Order;
import com.edu.service.OrderService;
import com.edu.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@GetMapping("")
    public List<ProductDTO> getAllProducts() {
        return productService.findAllProducts();  // Trả về danh sách ProductDTO
    }

    @GetMapping("/{productId}")
    public Optional<ProductDTO> getProductById(@PathVariable Long productId) {
        return productService.findProductById(productId);  // Trả về ProductDTO
    }

	// Lọc theo category
	@GetMapping("/category/{categoryName}")
	public List<ProductDTO> getProductsByCategory(@PathVariable String categoryName) {
		return productService.findByCategoryCategoryName(categoryName);
	}
	
	// Lọc theo khoảng giá
	@GetMapping("/price")
	public List<ProductDTO> getProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
		return productService.findByPriceBetween(minPrice, maxPrice);
	}

	// Lọc theo style
	@GetMapping("/style/{styleName}")
	public List<ProductDTO> getProductsByStyle(@PathVariable String styleName) {
		return productService.findByStyleStyleName(styleName);
	}

	// Lọc theo color
	@GetMapping("/color/{colorName}")
	public List<ProductDTO> getProductsByColor(@PathVariable String colorName) {
		return productService.findByColorsColorName(colorName);
	}

	// Lọc theo size
	@GetMapping("/size/{sizeName}")
	public List<ProductDTO> getProductsBySize(@PathVariable String sizeName) {
		return productService.findBySizesSizeName(sizeName);
	}

	// Lọc kết hợp nhiều tiêu chí
	@GetMapping("/filter")
	public List<ProductDTO> filterProducts(@RequestParam String name, @RequestParam double minPrice, @RequestParam double maxPrice, 
			@RequestParam String styleName, @RequestParam String colorName, @RequestParam String sizeName) {
		return productService.findByFilter(name, minPrice, maxPrice, styleName, colorName, sizeName);
	}

	@PostMapping("/buy")
	public Order buyNow(@RequestParam Long productId, @RequestParam Long userId, @RequestParam int quantity)
			throws Exception {
		Order order = orderService.buyProduct(productId, userId, quantity);
		return order;
	}

}
