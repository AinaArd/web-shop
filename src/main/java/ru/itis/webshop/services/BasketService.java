package ru.itis.webshop.services;

import ru.itis.webshop.dto.BasketDto;
import ru.itis.webshop.dto.OrderDetailsDto;
import ru.itis.webshop.dto.UserDto;

public interface BasketService {
    void setBasketForUser(UserDto user);

    BasketDto getBasketDtoById(Long basketId);

    void createOrder(Long basketId, OrderDetailsDto basketDto);
}
