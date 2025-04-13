package com.invenzo.myfirstdagger2app.manual.interfaces

/** Logic to process some user input.  */
interface Command {


    /** Process the rest of the command's words and do something.  */
    fun handleInput(input: List<String?>?): Result?

    /**
     * This wrapper class is introduced to make a future change easier
     * even though it looks unnecessary right now.
     */
    class Result private constructor(private val status: Status) {
        fun status(): Status {
            return status
        }

        companion object {
            fun invalid(): Result {
                return Result(Status.INVALID)
            }

            fun handled(): Result {
                return Result(Status.HANDLED)
            }
        }
    }

    enum class Status {
        INVALID,
        HANDLED
    }
}