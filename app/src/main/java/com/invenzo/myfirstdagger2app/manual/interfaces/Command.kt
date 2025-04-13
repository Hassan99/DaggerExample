package com.invenzo.myfirstdagger2app.manual.interfaces

import com.invenzo.myfirstdagger2app.manual.commandshelpers.CommandRouter
import java.util.Optional


interface Command {
    fun handleInput(input: List<String?>?): Result?

    class Result private constructor(
        private val status: Status,
        private val nestedCommandRouter: Optional<CommandRouter>
    ) {
        fun status(): Status {
            return status
        }

        fun nestedCommandRouter(): Optional<CommandRouter> {
            return nestedCommandRouter
        }

        companion object {
            fun invalid(): Result {
                return Result(Status.INVALID, Optional.empty())
            }

            fun handled(): Result {
                return Result(Status.HANDLED, Optional.empty())
            }

            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result {
                return Result(Status.HANDLED, Optional.of(nestedCommandRouter))
            }
        }
    }

    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}