package com.invenzo.myfirstdagger2app.manual.factory

import com.invenzo.myfirstdagger2app.manual.commandshelpers.CommandRouter
import com.invenzo.myfirstdagger2app.manual.module.DepositModule
import com.invenzo.myfirstdagger2app.manual.module.HelloWorldModule
import com.invenzo.myfirstdagger2app.manual.module.LoginCommandModule
import com.invenzo.myfirstdagger2app.manual.module.SystemOutModule
import dagger.Component

@Component(modules = [HelloWorldModule::class,LoginCommandModule::class, SystemOutModule::class, DepositModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}