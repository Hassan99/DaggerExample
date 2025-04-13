package com.invenzo.myfirstdagger2app.manual.implementation

import com.invenzo.myfirstdagger2app.manual.helper.SingleArgCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import com.invenzo.myfirstdagger2app.manual.interfaces.Command.Result.Companion.handled
import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import javax.inject.Inject


internal class HelloWorldCommand @Inject constructor(private val outputter: Outputter?) :
    SingleArgCommand() {


    public override fun handleArg(txt: String?): Command.Result? {
        outputter?.output("$txt World")
        return handled()
    }
}