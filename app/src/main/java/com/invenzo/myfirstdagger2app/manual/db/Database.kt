package com.invenzo.myfirstdagger2app.manual.db

import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 class Database @Inject constructor() {
    private val accounts: MutableMap<String, Account> = HashMap()

    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username) { username: String -> Account(username) }
    }

    class Account(private val username: String) {
        private var balance: BigDecimal = BigDecimal.ZERO

        fun username(): String {
            return username
        }

        fun balance(): BigDecimal {
            return balance
        }

        fun deposit(amount: BigDecimal?) {
            balance = balance.add(amount)
        }
    }
}