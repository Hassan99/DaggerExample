package com.invenzo.myfirstdagger2app.manual.implementation

import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import com.invenzo.myfirstdagger2app.manual.interfaces.Command.Result.Companion.handled
import com.invenzo.myfirstdagger2app.manual.interfaces.Command.Result.Companion.invalid
import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import javax.inject.Inject


class HelloWorldCommand @Inject constructor(private val outputter: Outputter?) : Command {


    override fun key(): String? {
        return "hello"
    }

    override fun handleInput(input: List<String?>?): Command.Result? {
        if (input!!.isNotEmpty()) {
            return invalid()
        }
        outputter!!.output("world!")
        return handled()
    }
}