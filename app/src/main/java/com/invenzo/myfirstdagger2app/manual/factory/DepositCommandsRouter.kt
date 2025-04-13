package com.invenzo.myfirstdagger2app.manual.factory

import com.invenzo.myfirstdagger2app.manual.commandshelpers.CommandRouter
import com.invenzo.myfirstdagger2app.manual.db.Database
import com.invenzo.myfirstdagger2app.manual.module.DepositModule
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [DepositModule::class])
internal interface DepositCommandsRouter {
    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance account: Database.Account): DepositCommandsRouter
    }

    @Module(subcomponents = [DepositCommandsRouter::class])
    interface InstallationModule
}