package com.invenzo.myfirstdagger2app.manual.implementation

import com.invenzo.myfirstdagger2app.manual.helper.SingleArgCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import com.invenzo.myfirstdagger2app.manual.interfaces.Command.Result.Companion.handled
import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import java.math.BigDecimal

internal abstract class BigDecimalCommand protected constructor(private val outputter: Outputter) :
    SingleArgCommand() {
    override fun handleArg(arg: String?): Command.Result? {
        val amount = tryParse(arg)
        if (amount == null) {
            outputter.output("$arg is not a valid number")
        } else if (amount.signum() <= 0) {
            outputter.output("amount must be positive")
        } else {
            handleAmount(amount)
        }
        return handled()
    }

    /** Handles the given (positive) `amount` of money.  */
    protected abstract fun handleAmount(amount: BigDecimal?)

    companion object {
        private fun tryParse(arg: String?): BigDecimal? {
            return try {
                BigDecimal(arg)
            } catch (e: NumberFormatException) {
                null
            }
        }
    }
}