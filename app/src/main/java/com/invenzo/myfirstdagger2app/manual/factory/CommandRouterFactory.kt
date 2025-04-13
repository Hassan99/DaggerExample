package com.invenzo.myfirstdagger2app.manual.factory

import com.invenzo.myfirstdagger2app.manual.commandshelpers.CommandRouter
import com.invenzo.myfirstdagger2app.manual.implementation.HelloWorldCommand
import com.invenzo.myfirstdagger2app.manual.module.DepositeModule
import com.invenzo.myfirstdagger2app.manual.module.HelloWorldModule
import com.invenzo.myfirstdagger2app.manual.module.LoginCommandModule
import com.invenzo.myfirstdagger2app.manual.module.SystemOutModule
import dagger.Component

@Component(modules = [HelloWorldCommand::class,LoginCommandModule::class, SystemOutModule::class, DepositeModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}