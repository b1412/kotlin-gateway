package com.github.b1412.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = ["com.github.b1412.gateway.client"])
class GatewayApplication {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(GatewayApplication::class.java, *args)
        }
    }

}

