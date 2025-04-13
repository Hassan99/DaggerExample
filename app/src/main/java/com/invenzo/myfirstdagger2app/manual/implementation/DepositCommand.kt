package com.invenzo.myfirstdagger2app.manual.implementation

import com.invenzo.myfirstdagger2app.manual.db.Database
import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import java.math.BigDecimal
import javax.inject.Inject


internal class DepositCommand @Inject constructor(
    private val account: Database.Account, private val outputter: Outputter
) : BigDecimalCommand(outputter) {


    override fun handleAmount(amount: BigDecimal?) {
        account.deposit(amount)
        outputter.output(account.username() + " now has: " + account.balance())
    }
}