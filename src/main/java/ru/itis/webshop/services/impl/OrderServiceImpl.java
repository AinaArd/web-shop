package ru.itis.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.webshop.dto.OrderDto;
import ru.itis.webshop.models.Order;
import ru.itis.webshop.repositories.OrderRepository;
import ru.itis.webshop.services.OrderService;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto getOrderDtoById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            return OrderDto.from(orderOptional.get());
        } else {
            return OrderDto.empty();
        }
    }
}
