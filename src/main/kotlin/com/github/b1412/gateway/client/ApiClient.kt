package com.github.b1412.gateway.client

import com.github.leon.payment.client.LoginResp
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@Component
@FeignClient("api")
interface ApiClient {

    @PostMapping("/v1/login")
    fun login(@RequestParam("username") username: String,
              @RequestParam("password") password: String,
              @RequestParam("clientId") clientId: String): LoginResp

    @GetMapping("/v1/permission/filter")
    fun filter(@RequestHeader("Authorization") token: String,
               @RequestParam method: String,
               @RequestParam uri: String): Map<String, String>


//    @PostMapping("/payment/pay")
//    @ResponseBody
//    fun payWithToken(@RequestHeader("Authorization") token: String, @RequestBody paymentReq: PaymentReq): PaymentResp


}
