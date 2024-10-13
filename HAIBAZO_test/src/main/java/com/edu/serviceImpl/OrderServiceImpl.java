package com.edu.serviceImpl;

import com.edu.model.Order;
import com.edu.model.OrderDetail;
import com.edu.model.Product;
import com.edu.model.User;
import com.edu.repository.OrderDetailRepository;
import com.edu.repository.OrderRepository;
import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    
    @Override
	public Order buyProduct(Long productId, Long userId, int quantity) throws Exception {
	    // Fetch product and user details
	    Product product = productRepository.findById(productId)
	            .orElseThrow(() -> new Exception("Không tìm thấy sản phẩm!"));
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new Exception("Không tìm thấy người dùng!"));

	    // Check if there's enough quantity
	    if (product.getQuantity() < quantity) {
	        throw new Exception("Số lượng sản phẩm không đủ!");
	    }

	    // Create new order
	    Order order = new Order();
	    order.setUser(user);
	    order.setTotalPrice(product.getPrice() * quantity);
	    order.setOrderStatus("Đã xác nhận!");

	    // Save the order
	    order = orderRepository.save(order);

	    // Create order detail
	    OrderDetail orderDetail = new OrderDetail();
	    orderDetail.setOrder(order);
	    orderDetail.setProduct(product);
	    orderDetail.setPrice(product.getPrice());
	    orderDetail.setQuantity(quantity);
	    orderDetail.setTotal(product.getPrice() * quantity);
	    orderDetailRepository.save(orderDetail);

	    // Update product quantity
	    product.setQuantity(product.getQuantity() - quantity);
	    productRepository.save(product);

	    return order;
	}
}
