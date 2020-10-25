package ru.itis.webshop.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.webshop.models.Order;
import ru.itis.webshop.models.Product;
import ru.itis.webshop.models.enums.Status;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private Date date;
    private Status status;
    private Double totalPrice;
    private List<Product> products;

    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .date(order.getDate())
                .products(order.getProducts())
                .status(order.getStatus())
                .totalPrice(order.getTotalPrice())
                .build();
    }

    public static OrderDto empty() {
        return OrderDto.builder().build();
    }
}
