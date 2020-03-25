package com.github.leon.payment.client

data class LoginResp (
        val access_token: String? = null,
        val expires_in: Double? = null,
        val type: String? = null
)