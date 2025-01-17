package ru.itis.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.webshop.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
