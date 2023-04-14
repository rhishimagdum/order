package com.ness.ms.config;

import com.ness.ms.resource.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class BeanConfiguration {
    @Bean
    Order getDefOrder() {
        return new Order(1L, 1L, LocalDate.now(), 100.0, "InProgress");
    }

    @Bean
    @Qualifier("getDefOrder2")
    Order getDefOrder2() {
        return new Order(2L, 2L, LocalDate.now(), 200.0, "InProgress");
    }
}
