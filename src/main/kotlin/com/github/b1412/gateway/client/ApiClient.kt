package com.github.b1412.gateway.client

import com.github.leon.payment.client.LoginResp
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Component
@FeignClient("api")
interface ApiClient {

    @PostMapping(value = ["/v1/login"])
    fun login(@RequestParam("username") username: String,
              @RequestParam("password") password: String,
              @RequestParam("clientId") clientId: String): LoginResp


//    @PostMapping("/payment/pay")
//    @ResponseBody
//    fun payWithToken(@RequestHeader("Authorization") token: String, @RequestBody paymentReq: PaymentReq): PaymentResp


}
