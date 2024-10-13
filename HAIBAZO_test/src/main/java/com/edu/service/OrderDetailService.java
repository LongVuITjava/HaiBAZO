package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.OrderDetail;

public interface OrderDetailService {

	void deleteOrderDetail(Long orderDetailId);

	OrderDetail saveOrderDetail(OrderDetail orderDetail);

	Optional<OrderDetail> getOrderDetailById(Long orderDetailId);

	List<OrderDetail> getAllOrderDetails();


}
