package ru.itis.webshop.services;

import ru.itis.webshop.dto.UserDto;

public interface BasketService {
    void setBasketForUser(UserDto user);
}
