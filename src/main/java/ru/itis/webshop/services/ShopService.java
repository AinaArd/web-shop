package ru.itis.webshop.services;

import ru.itis.webshop.dto.ShopDto;
import ru.itis.webshop.models.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAll();

    ShopDto getShopDtoById(Long shopId);
}
