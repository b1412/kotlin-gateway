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
        val request = exchange.request
        val path = request.uri.path
        val method = request.method!!.name
        println(path)
        println(method)
        if (path == "/v1/login" || path == "/v1/logout") {
            return Mono.empty()
        }
        //val resp = apiClient.login("admin", "1qazxsw2", "4")
        val token = request.headers["Authorization"]?.get(0)
        println(token)
        if (token==null){
            // 403
        }
        val resp = apiClient.filter(token!!, method, path)
        println(resp)
        return chain.filter(exchange)
    }
}