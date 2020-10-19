package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.ShopDto;
import ru.itis.webshop.models.Shop;
import ru.itis.webshop.services.ShopService;

import java.util.List;

@Controller
@RequestMapping("/shops")
public class ShopController {
    //    GET /shops/{shop-id}
    private ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String getAllShops(ModelMap model) {
        List<Shop> shops = shopService.getAll();
        model.addAttribute("shops", shops);
        return "allshops";
    }

    @GetMapping("/{shopId}")
    public String getShopPage(@PathVariable Long shopId, ModelMap model) {
        ShopDto shop = shopService.getShopDtoById(shopId);
        model.addAttribute("shop", shop);
        return "shop";
    }

}
