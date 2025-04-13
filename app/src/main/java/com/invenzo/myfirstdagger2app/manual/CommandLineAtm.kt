package com.invenzo.myfirstdagger2app.manual

import com.invenzo.myfirstdagger2app.manual.commandshelpers.CommandProcessor
import com.invenzo.myfirstdagger2app.manual.factory.CommandProcessorFactory
import com.invenzo.myfirstdagger2app.manual.factory.DaggerCommandProcessorFactory
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import java.util.Scanner


internal object CommandLineAtm {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val commandProcessorFactory: CommandProcessorFactory =
            DaggerCommandProcessorFactory.create()
        val commandProcessor: CommandProcessor =
            commandProcessorFactory.commandProcessor()

        while (scanner.hasNextLine()) {
            val unused: Command.Status = commandProcessor.process(scanner.nextLine())
        }
    }
}