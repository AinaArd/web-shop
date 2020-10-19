package ru.itis.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.models.Basket;
import ru.itis.webshop.models.User;
import ru.itis.webshop.repositories.BasketRepository;
import ru.itis.webshop.repositories.UserRepository;
import ru.itis.webshop.services.BasketService;

@Service
public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;
    private UserRepository userRepository;

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository, UserRepository userRepository) {
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
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

    private Basket createEmptyBasket() {
        Basket basket = new Basket();
        return basketRepository.save(basket);
    }
}
