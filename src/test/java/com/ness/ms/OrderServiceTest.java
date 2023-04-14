package com.ness.ms;

import com.ness.ms.repository.OrderRepository;
import com.ness.ms.resource.Item;
import com.ness.ms.resource.Order;
import com.ness.ms.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderServiceMock;

    @Autowired
    OrderService orderService;


    @Test
    void getOrderTest (){

    }

    @Test
    void testCreateOrder() {
        Order order = new Order(111l,1l, LocalDate.now(), 41.5, "New");
        Item item1 = new Item(order, 3L, 10.5);
        Item item2 = new Item(order, 2L, 10.5);
        orderService.createOrder(order);
    }


}
