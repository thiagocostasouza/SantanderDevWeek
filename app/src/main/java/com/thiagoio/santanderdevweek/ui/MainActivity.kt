package com.thiagoio.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.TextureView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thiagoio.santanderdevweek.R
import com.thiagoio.santanderdevweek.data.Conta
import com.thiagoio.santanderdevweek.extensions.toMoneyFormat

class MainActivity : AppCompatActivity() {


    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        observerLive()
    }

    private fun observerLive() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.buscarContaCliente().observe(this, { result ->
            bindView(result)
        })
    }

    private fun bindView(conta: Conta){
        findViewById<TextView>(R.id.tv_agenciaNum).text = conta.agencia.toString()
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente
        findViewById<TextView>(R.id.tv_conta_corrente_num).text = conta.num.toString()
        findViewById<TextView>(R.id.tv_saldoNum).text = conta.saldo.toMoneyFormat()
        findViewById<TextView>(R.id.tv_saldo_com_limite_num).text = conta.limite.toMoneyFormat()
        findViewById<TextView>(R.id.num_cartao_final).text = conta.cartao.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item -> {
                Log.d("CLICK", "Click no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
