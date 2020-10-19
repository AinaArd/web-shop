package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.ProductDto;
import ru.itis.webshop.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public String getProductPage(@PathVariable Long productId, ModelMap model) {
        ProductDto product = productService.getProductDtoById(productId);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/{productId}")
    public String buyProduct(@PathVariable Long productId) {
        return "redirect:product";
    }
}
