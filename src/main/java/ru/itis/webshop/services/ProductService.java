package ru.itis.webshop.services;

import ru.itis.webshop.dto.ProductDto;
import ru.itis.webshop.dto.UserDto;

public interface ProductService {
    ProductDto getProductDtoById(Long productId);

    void addProductToBasket(Long productId, UserDto userDto);
}
