package ru.itis.webshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.webshop.models.Basket;
import ru.itis.webshop.models.Product;
import ru.itis.webshop.models.User;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BasketDto {
    private User user;
    private List<Product> products;

    public static BasketDto from(Basket basket) {
        return BasketDto.builder()
                .user(basket.getUser())
                .products(basket.getProducts())
                .build();
    }

    public static BasketDto empty() {
        return BasketDto.builder().build();
    }
}
