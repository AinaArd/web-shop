package ru.itis.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.webshop.dto.ProductDto;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.models.Product;
import ru.itis.webshop.models.User;
import ru.itis.webshop.repositories.ProductRepository;
import ru.itis.webshop.services.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProductDtoById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            return ProductDto.from(productOptional.get());
        } else {
            return ProductDto.empty();
        }
    }
}
