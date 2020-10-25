package ru.itis.webshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.webshop.models.Basket;
import ru.itis.webshop.models.Order;
import ru.itis.webshop.models.User;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String login;
    private Basket basket;
    private String password;
    private List<Order> orders;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .basket(user.getBasket())
                .orders(user.getOrders())
                .build();
    }

    public static UserDto empty() {
        return UserDto.builder().build();
    }
}
