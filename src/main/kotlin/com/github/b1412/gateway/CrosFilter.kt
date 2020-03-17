package com.github.b1412.gateway

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.web.cors.reactive.CorsUtils
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono


class CrosFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val request = exchange.request
        if (CorsUtils.isCorsRequest(request)) {
            val response = exchange.response
            val headers = response.headers
            headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN)
            headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS)
            headers.add("Access-Control-Max-Age", MAX_AGE)
            headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS)
            headers.add("Access-Control-Expose-Headers", ALLOWED_Expose)
            headers.add("Access-Control-Allow-Credentials", "true")
            if (request.method === HttpMethod.OPTIONS) {
                response.statusCode = HttpStatus.OK
                return Mono.empty()
            }
        }
        return chain.filter(exchange)
    }

    companion object {
        private const val ALLOWED_HEADERS = "Cache-Control,x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client"
        private const val ALLOWED_METHODS = "*"
        private const val ALLOWED_ORIGIN = "*"
        private const val ALLOWED_Expose = "*"
        private const val MAX_AGE = "18000L"
    }
}