package com.thiagoio.santanderdevweek.local

import com.thiagoio.santanderdevweek.data.Cartao
import com.thiagoio.santanderdevweek.data.Cliente
import com.thiagoio.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Thiago")
        val cartao = Cartao(123458 - 5)

        return Conta(
            123458 - 5,
            4548 - 48,
            120000,
            400000,
            cliente.nome,
            cartao.numCartao
        )
    }
}
