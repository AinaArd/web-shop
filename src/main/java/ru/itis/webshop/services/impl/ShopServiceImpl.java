package ru.itis.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.webshop.dto.ShopDto;
import ru.itis.webshop.models.Shop;
import ru.itis.webshop.repositories.ShopRepository;
import ru.itis.webshop.services.ShopService;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Override
    public ShopDto getShopDtoById(Long shopId) {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        if (shopOptional.isPresent()) {
            return ShopDto.from(shopOptional.get());
        } else {
            return ShopDto.empty();
        }
    }
}
