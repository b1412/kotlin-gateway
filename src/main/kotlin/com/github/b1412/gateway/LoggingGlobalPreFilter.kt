package com.github.b1412.gateway

import com.github.b1412.gateway.client.ApiClient
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class LoggingGlobalPreFilter(
        val apiClient: ApiClient
) : GlobalFilter {


    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        val resp = apiClient.login("admin", "1qazxsw2", "4")
        println(resp)
        println("Global Pre Filter executed")
        return chain.filter(exchange)
    }
}