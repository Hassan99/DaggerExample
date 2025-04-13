package com.invenzo.myfirstdagger2app.manual

import com.invenzo.myfirstdagger2app.manual.factory.DaggerCommandRouterFactory
import java.util.Scanner

internal object CommandLineAtm {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        /*   CommandRouter commandRouter = new CommandRouter();

    while (scanner.hasNextLine()) {
      Command.Result unused = commandRouter.route(scanner.nextLine());
    }
*/
        val commandRouterFactory = DaggerCommandRouterFactory.create()
        val commandRouter = commandRouterFactory.router()
        while (scanner.hasNextLine()) {
            val unused = commandRouter.route(scanner.nextLine())
        }
    }
}