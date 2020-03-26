package com.github.b1412.gateway.config

import feign.RequestInterceptor
import feign.RequestTemplate
import feign.codec.Decoder
import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.request.RequestContextHolder


@Configuration
class FeignResponseDecoderConfig {
    private val messageConverters = ObjectFactory { HttpMessageConverters() }

    @Bean
    fun feignFormEncoder(): Encoder {
        return SpringFormEncoder(SpringEncoder(messageConverters))
    }

    @Bean
    fun feignFormDecoder(): Decoder {
        return SpringDecoder(messageConverters)
    }

    @Bean
    fun requestInterceptor(): RequestInterceptor? {

        return RequestInterceptor { requestTemplate: RequestTemplate ->
            if (RequestContextHolder.getRequestAttributes() != null) {
                val request = RequestContextHolder.getRequestAttributes()!!
                println(request)
            }
            requestTemplate.header("Content-Type", "application/json")
            requestTemplate.header("Accept", "application/json")
        }
    }
}