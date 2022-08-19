package com.hcl.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.Order;
import com.hcl.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public synchronized boolean addOrder(Order order) {
		orderRepository.save(order);
		return true;
	}

	@Override
	public Order getOrderById(Integer orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order.isPresent())
			return order.get();
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		Order o = getOrderById(order.getId());
		o.setDate(order.getDate());
		o.setAmount(order.getAmount());
		o.setStatus(order.getStatus());
		orderRepository.save(o);
	}

	@Override
	public void deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
	}

}
