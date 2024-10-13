package com.edu.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.model.Cart;
import com.edu.model.Product;
import com.edu.repository.ProductRepository;
import com.edu.serviceImpl.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public List<Cart> getCart(HttpSession session) {
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        return cart;
    }

    @PostMapping("/add")
    public List<Cart> addToCart(@RequestParam Long productId, @RequestParam int quantity, HttpSession session) throws Exception {
        // Lấy giỏ hàng từ session
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Lấy thông tin sản phẩm từ database
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new Exception("Không tìm thấy sản phẩm!"));

        // Thêm sản phẩm vào giỏ hàng
        cart = cartService.addProductToCart(cart, product, quantity);

        // Lưu giỏ hàng vào session
        session.setAttribute("cart", cart);

        return cart;
    }

    @DeleteMapping("/remove")
    public List<Cart> removeFromCart(@RequestParam Long productId, HttpSession session) {
        // Lấy giỏ hàng từ session
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Xóa sản phẩm khỏi giỏ hàng
        cart = cartService.removeProductFromCart(cart, productId);

        // Cập nhật lại giỏ hàng trong session
        session.setAttribute("cart", cart);

        return cart;
    }
}
