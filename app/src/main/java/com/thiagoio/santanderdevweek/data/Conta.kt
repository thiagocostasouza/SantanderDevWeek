package com.thiagoio.santanderdevweek.data

data class Conta(
    val num: Int,
    val agencia: Int,
    val saldo: Int,
    val limite: Int,
    val cliente: String,
    val cartao: Int
)