package com.invenzo.myfirstdagger2app.manual.implementation

import com.invenzo.myfirstdagger2app.manual.helper.SingleArgCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import javax.inject.Inject

internal class LoginCommand @Inject constructor(private val outputter: Outputter) :
    SingleArgCommand() {

    override fun key(): String {
        return "login"
    }

    public override fun handleArg(username: String?): Command.Result? {
        outputter.output("$username is logged in.")
        return Command.Result.handled()
    }
}