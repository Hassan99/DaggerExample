package com.invenzo.myfirstdagger2app.manual.module

import com.invenzo.myfirstdagger2app.manual.implementation.LoginCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
internal abstract class LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    abstract fun loginCommand(command: LoginCommand?): Command?
}