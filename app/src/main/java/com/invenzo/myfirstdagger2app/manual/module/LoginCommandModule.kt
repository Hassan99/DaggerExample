package com.invenzo.myfirstdagger2app.manual.module

import com.invenzo.myfirstdagger2app.manual.implementation.HelloWorldCommand
import com.invenzo.myfirstdagger2app.manual.implementation.LoginCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
internal abstract class LoginCommandModule {
    @Binds
    @IntoSet
    abstract fun loginCommand(command: LoginCommand?): Command?
}