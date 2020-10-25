package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.BasketDto;
import ru.itis.webshop.dto.OrderDetailsDto;
import ru.itis.webshop.services.BasketService;

@Controller
@RequestMapping("/baskets")
public class BasketController {

    private BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/{basketId}")
    public String getBasket(@PathVariable Long basketId, ModelMap model) {
        BasketDto basket = basketService.getBasketDtoById(basketId);
        model.addAttribute("basket", basket);
        return "basket";
    }

    @PostMapping("/{basketId}")
    public String makeOrder(@PathVariable Long basketId, OrderDetailsDto orderDetailsDto) {
        basketService.createOrder(basketId, orderDetailsDto);
        return "redirect:/baskets/" + basketId;
    }
}
