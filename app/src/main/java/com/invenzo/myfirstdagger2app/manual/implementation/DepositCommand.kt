package com.invenzo.myfirstdagger2app.manual.implementation

import com.invenzo.myfirstdagger2app.manual.helper.SingleArgCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import com.invenzo.myfirstdagger2app.manual.interfaces.Command.Result.Companion.handled
import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import javax.inject.Inject

internal class DepositCommand @Inject constructor(private val outputter: Outputter) :  SingleArgCommand() {

    public override fun handleArg(amount: String?): Command.Result? {
        outputter.output("Your Money $amount deposited")
        return handled()
    }
}