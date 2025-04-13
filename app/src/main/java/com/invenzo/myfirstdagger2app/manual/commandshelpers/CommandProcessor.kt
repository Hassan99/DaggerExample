package com.invenzo.myfirstdagger2app.manual.commandshelpers

import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import java.util.ArrayDeque
import java.util.Deque
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor @Inject constructor(firstCommandRouter: CommandRouter) {
    private val commandRouterStack: Deque<CommandRouter> = ArrayDeque()

    init {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String?): Command.Status {
        val result = commandRouterStack.peek().route(
            input!!
        )
        if (result.status() == Command.Status.INPUT_COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty()
            ) Command.Status.INPUT_COMPLETED else Command.Status.HANDLED
        }

        result.nestedCommandRouter().ifPresent { e: CommandRouter -> commandRouterStack.push(e) }
        return result.status()
    }
}