package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.Order;

public interface OrderService {

	void deleteOrder(Long orderId);

	Order saveOrder(Order order);

	Optional<Order> getOrderById(Long orderId);

	List<Order> getAllOrders();

	Order buyProduct(Long productId, Long userId, int quantity) throws Exception;


}
