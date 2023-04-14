package com.ness.ms.controller;

import com.ness.ms.resource.Order;
import com.ness.ms.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Value("${server.port}")
    String port;

    @GetMapping("/order/info")
    String getInfo(HttpServletRequest req) {
        return req.getRemoteHost()+ " " +req.getRequestURI() + " "+port + orderService.getConfig();
    }

    @GetMapping("/defaultOrder")
    Order getDefaultOrder() {
        return orderService.getDefaultOrder();
    }

    @PostMapping("/orders")
    Order createOrder(@RequestBody Order order) {
       return orderService.createOrder(order);
    }

    @GetMapping("/orders")
    List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/orders/{id}")
    Order getById(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @DeleteMapping("/orders/{id}")
    void deleteById(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}