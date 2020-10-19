package ru.itis.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.webshop.dto.ProductDto;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.models.Basket;
import ru.itis.webshop.models.Order;
import ru.itis.webshop.models.Product;
import ru.itis.webshop.models.User;
import ru.itis.webshop.repositories.BasketRepository;
import ru.itis.webshop.repositories.OrderRepository;
import ru.itis.webshop.repositories.ProductRepository;
import ru.itis.webshop.services.ProductService;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private BasketRepository basketRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BasketRepository basketRepository) {
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
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

    @Override
    public void addProductToBasket(Long productId, UserDto user) {
        Product product = productRepository.findById(productId).get();
        Basket basket = user.getBasket();
        basket.getProducts().add(product);
        basketRepository.save(basket);
//        создать новый заказ, добавить его пользователю и в корзину

    }
}
