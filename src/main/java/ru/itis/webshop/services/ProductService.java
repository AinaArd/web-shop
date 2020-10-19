package ru.itis.webshop.services;

import ru.itis.webshop.dto.ProductDto;

public interface ProductService {
    ProductDto getProductDtoById(Long productId);
}
