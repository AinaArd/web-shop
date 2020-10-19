package ru.itis.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.webshop.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
