package com.invenzo.myfirstdagger2app.manual.implementation

import com.invenzo.myfirstdagger2app.manual.db.Database
import com.invenzo.myfirstdagger2app.manual.factory.DepositCommandsRouter
import com.invenzo.myfirstdagger2app.manual.helper.SingleArgCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import javax.inject.Inject

internal class LoginCommand @Inject constructor(
    private val db: Database,
    private val outputter: Outputter,
    private val depositCommandRouter: DepositCommandsRouter.Factory
) :
    SingleArgCommand() {

    public override fun handleArg(username: String?): Command.Result {
        val account = db.getAccount(username!!)
        outputter.output("Welcome back ${account.username()}, Your Bank Balance is ${account.balance()} ")

        return Command.Result.enterNestedCommandSet(
            depositCommandRouter.create(account)?.router()!!
        );
    }
}