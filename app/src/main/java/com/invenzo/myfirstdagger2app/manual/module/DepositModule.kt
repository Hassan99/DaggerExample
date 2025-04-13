package com.invenzo.myfirstdagger2app.manual.module

import com.invenzo.myfirstdagger2app.manual.implementation.DepositCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
internal abstract class DepositModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(command: DepositCommand?): Command?
}