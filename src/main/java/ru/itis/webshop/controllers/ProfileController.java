package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.models.User;
import ru.itis.webshop.services.UserService;

@Controller
@RequestMapping("/users")
public class ProfileController {
    private UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public String getUserProfile(@PathVariable Long userId, ModelMap model) {
        UserDto user = userService.getUserDtoById(userId);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/{userId}/baskets/{basketId}")
    public String getBasket(@PathVariable Long basketId, @PathVariable Long userId, ModelMap model) {
        User user = userService.findUserById(userId);
        model.addAttribute("basket", user.getBasket());
        return "basket";
    }
}
