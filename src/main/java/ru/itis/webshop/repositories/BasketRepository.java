package ru.itis.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.webshop.models.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}
