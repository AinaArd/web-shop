package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.ProductDto;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.services.ProductService;
import ru.itis.webshop.services.UserService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private UserService userService;

    @Autowired
    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/{productId}")
    public String getProductPage(@PathVariable Long productId, ModelMap model) {
        ProductDto product = productService.getProductDtoById(productId);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/{productId}")
    public String addToBasket(@PathVariable Long productId) {
//        TODO: find current user
        UserDto user = userService.getUserDtoById(1L);
        productService.addProductToBasket(productId, user);
        return "redirect:/baskets/" + user.getBasket().getId();
    }
}
