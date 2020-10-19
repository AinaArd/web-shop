package ru.itis.webshop.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.webshop.models.Product;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Double price;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static ProductDto empty() {
        return ProductDto.builder().build();
    }
}
