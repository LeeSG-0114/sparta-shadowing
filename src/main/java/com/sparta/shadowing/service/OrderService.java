package com.sparta.shadowing.service;

import com.sparta.shadowing.dto.OrderResponse;
import com.sparta.shadowing.entity.Order;
import com.sparta.shadowing.entity.Product;
import com.sparta.shadowing.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Transactional
    public OrderResponse createOrder(Long productId) {
        Product product = productService.findProductById(productId);
        Order order = new Order(product);
        Order saved = orderRepository.save(order);
        return new OrderResponse(saved);
    }

    public OrderResponse getOrder(Long id) {
        Order order = findOrderById(id);
        return new OrderResponse(order);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 주문은 존재하지 않습니다. id = " + id));
    }
}
