package com.invenzo.myfirstdagger2app.manual.commandshelpers

import com.invenzo.myfirstdagger2app.manual.interfaces.Command

import javax.inject.Inject

class CommandRouter @Inject constructor(
    private val commands: Map<String, @JvmSuppressWildcards Command>
) {

    fun route(input: String): Command.Result {
        val splitInput = input.trim().split("\\s+".toRegex())
        if (splitInput.isEmpty()) return invalidCommand(input)

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)
        var args = emptyList<String>()
        if (splitInput.size > 1) {
          args = splitInput.drop(1)
        }else{
            args = splitInput
        }
        return command.handleInput(args)?.takeIf {
            it.status() != Command.Status.INVALID
        } ?: invalidCommand(input)
    }

    private fun invalidCommand(input: String): Command.Result {
        println("Couldn't understand \"$input\". Please try again.")
        return Command.Result.invalid()
    }
}