package com.invenzo.myfirstdagger2app.manual.factory

import com.invenzo.myfirstdagger2app.manual.commandshelpers.CommandProcessor
import com.invenzo.myfirstdagger2app.manual.module.DepositModule
import com.invenzo.myfirstdagger2app.manual.module.HelloWorldModule
import com.invenzo.myfirstdagger2app.manual.module.LoginCommandModule
import com.invenzo.myfirstdagger2app.manual.module.SystemOutModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HelloWorldModule::class,
    LoginCommandModule::class,
    SystemOutModule::class,
    DepositCommandsRouter.InstallationModule::class])
interface CommandProcessorFactory {
    fun commandProcessor(): CommandProcessor
}