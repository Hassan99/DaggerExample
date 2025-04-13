package com.invenzo.myfirstdagger2app.manual.module

import com.invenzo.myfirstdagger2app.manual.implementation.DepositCommand
import com.invenzo.myfirstdagger2app.manual.implementation.HelloWorldCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
internal abstract class DepositeModule {
    @Binds
    @IntoSet
    abstract fun depositCommand(command: DepositCommand?): Command?
}