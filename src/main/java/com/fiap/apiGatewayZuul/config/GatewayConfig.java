package com.fiap.apiGatewayZuul.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("userManagement", r -> r.path("/userManagement/api/user/**")
                .uri("lb://userManagement"))
            .route("productRegistry", r -> r.path("/productRegistry/api/products/**")
                .uri("lb://productRegistry"))
            .route("orderManagement", r -> r.path("/orderManagement/api/order/**")
            	.uri("lb://orderManagement"))
            .route("DeliverLogistic", r -> r.path("/deliverLogistic/api/courier/**")
                	.uri("lb://DeliverLogistic"))
            .build();
    }
}