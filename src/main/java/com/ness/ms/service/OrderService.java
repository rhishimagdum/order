package com.ness.ms.service;

import com.ness.ms.repository.OrderRepository;
import com.ness.ms.resource.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    @Qualifier("getDefOrder2")
    Order order;

    @Value("${application.service.level}")
    String testConfig;

    private Order cOrder;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService (Order getDefOrder) {
        this.cOrder = getDefOrder;
    }

    public Order getDefaultOrder() {
        logger.debug("From logger Test config: {}", testConfig);
        System.out.println("Test config: "+ testConfig);
        return order;
    }

    public String getConfig() {
        return testConfig;
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
