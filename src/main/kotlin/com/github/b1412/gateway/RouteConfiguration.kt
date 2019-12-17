package com.github.b1412.gateway

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.server.WebFilter


@Configuration
open class RouteConfiguration {

    @Bean
    open fun corsFilter(): WebFilter {
        return CrosFilter()
    }

    /* */
    /**
     * 如果使用了注册中心（如：Eureka），进行控制则需要增加如下配置
     *//*
    @Bean
    open fun discoveryClientRouteDefinitionLocator(discoveryClient: DiscoveryClient): RouteDefinitionLocator {
        return DiscoveryClientRouteDefinitionLocator(discoveryClient)
    }*/


}

