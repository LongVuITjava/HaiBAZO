package com.edu.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.edu.model.Cart;
import com.edu.model.Color;
import com.edu.model.Product;
import com.edu.model.ProductImage;
import com.edu.model.Size;

@Service
public class CartService {

    public List<Cart> addProductToCart(List<Cart> cart, Product product, int quantity) {
        //kiểm tra xem sp có trong cart chưa
        for (Cart item : cart) {
            if (item.getProductId().equals(product.getProductId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return cart;
            }
        }

        //lấy list hình ảnh
        List<String> imageUrls = new ArrayList<>();
        for (ProductImage image : product.getProductImages()) {
            imageUrls.add(image.getImageUrl());
        }
        
     // lấy sizee
        List<String> sizeNames = new ArrayList<>();
        for (Size size : product.getSizes()) { 
            sizeNames.add(size.getSizeName()); 
        }

        // get color
        List<String> colorNames = new ArrayList<>();
        for (Color color : product.getColors()) { 
            colorNames.add(color.getColorName());
        }
        
        //thêm sp mới vào cart
        Cart newCartItem = new Cart(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getDiscount(),
                quantity,
                product.getRating(),
                product.getCategoryName(),
                product.getStyleName(),
                imageUrls, 
                sizeNames,
                colorNames
        );
        cart.add(newCartItem);
        return cart;
    }

    public List<Cart> removeProductFromCart(List<Cart> cart, Long productId) {
        cart.removeIf(item -> item.getProductId().equals(productId));
        return cart;
    }
}
