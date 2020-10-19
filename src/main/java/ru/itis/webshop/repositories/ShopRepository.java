package ru.itis.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.webshop.models.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
