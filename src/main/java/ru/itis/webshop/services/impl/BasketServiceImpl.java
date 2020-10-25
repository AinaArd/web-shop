package ru.itis.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.webshop.dto.BasketDto;
import ru.itis.webshop.dto.OrderDetailsDto;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.models.Basket;
import ru.itis.webshop.models.Order;
import ru.itis.webshop.models.Product;
import ru.itis.webshop.models.User;
import ru.itis.webshop.models.enums.Status;
import ru.itis.webshop.repositories.BasketRepository;
import ru.itis.webshop.repositories.OrderRepository;
import ru.itis.webshop.repositories.UserRepository;
import ru.itis.webshop.services.BasketService;

import java.time.Instant;
import java.util.*;

@Service
public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void setBasketForUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(IllegalArgumentException::new);
        Basket basket = createEmptyBasket();

        user.setBasket(basket);
        userRepository.save(user);

        basket.setUser(user);
        basketRepository.save(basket);
    }

    @Override
    public BasketDto getBasketDtoById(Long basketId) {
        Optional<Basket> basketOptional = basketRepository.findById(basketId);
        if (basketOptional.isPresent()) {
            return BasketDto.from(basketOptional.get());
        } else {
            return BasketDto.empty();
        }
    }

    @Override
    public void createOrder(Long basketId, OrderDetailsDto basketDto) {
        Basket basket = basketRepository.findById(basketId).get();
        User user = basket.getUser();
        Double price = countPrice(basket.getProducts());
        List<Product> products = basket.getProducts();
        basket.setProducts(null);

        Order newOrder = Order.builder()
                .date(Date.from(Instant.now()))
                .number(new Random().nextInt())
                .products(products)
                .status(Status.ОПЛАЧЕН)
                .totalPrice(price)
                .user(user)
                .build();

        orderRepository.save(newOrder);
        basketRepository.save(basket);
    }

    private Basket createEmptyBasket() {
        Basket basket = new Basket();
        return basketRepository.save(basket);
    }

    private Double countPrice(List<Product> products) {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
