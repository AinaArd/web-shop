package ru.itis.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.webshop.dto.OrderDto;
import ru.itis.webshop.services.OrderService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public String getOrderPage(@PathVariable Long orderId, ModelMap model) {
        OrderDto orderDto = orderService.getOrderDtoById(orderId);
        model.addAttribute("order", orderDto);
        return "order";
    }
}
