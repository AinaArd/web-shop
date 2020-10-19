package ru.itis.webshop.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.webshop.models.Product;
import ru.itis.webshop.models.Shop;
import ru.itis.webshop.models.User;

import java.util.List;

@Data
@Builder
public class ShopDto {
    private String name;
    private List<Product> products;

    public static ShopDto from(Shop shop) {
        return ShopDto.builder()
                .name(shop.getName())
                .products(shop.getProducts())
                .build();
    }

    public static ShopDto empty() {
        return ShopDto.builder().build();
    }
}
