package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.services.BasketService;
import ru.itis.webshop.services.UserService;

@Controller
@RequestMapping("/sign-up")
public class SingUpController {

    private UserService userService;
    private BasketService basketService;

    @Autowired
    public SingUpController(UserService userService, BasketService basketService) {
        this.userService = userService;
        this.basketService = basketService;
    }

    @GetMapping
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping
    public String signUpUser(ModelMap model, UserDto userDto) {
        UserDto user = userService.signUp(userDto);
        basketService.setBasketForUser(user);
        return "redirect:sign-in";
    }
}
