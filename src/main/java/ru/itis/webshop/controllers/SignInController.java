package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.services.UserService;

@Controller
@RequestMapping("/sign-in")
public class SignInController {

    private UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getSignInPage() {
        return "sign_in";
    }

    @PostMapping
    public String signInUser(UserDto userDto) {
        UserDto user = userService.signIn(userDto);
        return "redirect:users/" + user.getId();
    }
}
