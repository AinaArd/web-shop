package ru.itis.webshop.services;

import ru.itis.webshop.dto.OrderDto;

public interface OrderService {

    OrderDto getOrderDtoById(Long orderId);
}
