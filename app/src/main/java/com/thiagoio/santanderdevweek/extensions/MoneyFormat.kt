package com.thiagoio.santanderdevweek.extensions

import java.text.NumberFormat
import java.util.*

fun Int?.toMoneyFormat(): String {
    val locale = Locale("pt", "BR")
    return if (this == 0 || this == null) {
        NumberFormat.getCurrencyInstance(locale).format(0)
    } else NumberFormat.getCurrencyInstance(locale).format(this.toDouble() / 100)
}