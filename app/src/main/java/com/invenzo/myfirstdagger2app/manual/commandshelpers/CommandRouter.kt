package com.invenzo.myfirstdagger2app.manual.commandshelpers

import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import java.util.Arrays
import javax.inject.Inject


class CommandRouter @Inject constructor(cmd: Set<@JvmSuppressWildcards Command>) {

    private val commands = HashMap<String, Command>()

    init {
        cmd.iterator().forEachRemaining { addCommand(it) }
    }

    private fun addCommand(cmd: Command) {
        commands[cmd.key()!!] = cmd
    }

    fun route(input: String): Command.Result {
        val splitInput = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val args = splitInput.subList(1, splitInput.size)
        val result = command.handleInput(args)
        return if (result?.status() == Command.Status.INVALID) invalidCommand(input) else result!!
    }

    private fun invalidCommand(input: String): Command.Result {
        println(
            String.format("couldn't understand \"%s\". please try again.", input)
        )
        return Command.Result.invalid()
    }

    companion object {
        // Split on whitespace
        private fun split(input: String): List<String> {
            return Arrays.asList(
                *input.trim { it <= ' ' }.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray())
        }
    }
}