package com.invenzo.myfirstdagger2app.manual.helper

import com.invenzo.myfirstdagger2app.manual.interfaces.Command

/** Abstract command that accepts a single argument.  */
internal abstract class SingleArgCommand : Command {
    override fun handleInput(input: List<String?>?): Command.Result? {
        return if (input!!.size == 1) {
            handleArg(input[0])
        } else {
            Command.Result.invalid()
        }
    }

    /** Handles the single argument to the command.  */
    protected abstract fun handleArg(arg: String?): Command.Result?
}