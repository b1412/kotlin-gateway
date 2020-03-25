package com.github.b1412.gateway.config

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*
//import javax.servlet.http.HttpServletRequest

//@Configuration
class FeignConfig : RequestInterceptor {

    override fun apply(requestTemplate: RequestTemplate) {
//        if (RequestContextHolder.getRequestAttributes() != null) {
//            val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
//            val headers = getHeaders(request)
//            headers.forEach { k, v ->
//                requestTemplate.header(k, v)
//            }
//        }
    }

//    private fun getHeaders(request: HttpServletRequest): Map<String, String> {
//        val map = LinkedHashMap<String, String>()
//        val enumeration = request.headerNames
//        while (enumeration.hasMoreElements()) {
//            val key = enumeration.nextElement()
//            val value = request.getHeader(key)
//            map[key] = value
//        }
//        return map
//    }
}