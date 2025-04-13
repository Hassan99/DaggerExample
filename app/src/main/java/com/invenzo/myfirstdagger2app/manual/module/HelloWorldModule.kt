package com.invenzo.myfirstdagger2app.manual.module

import com.invenzo.myfirstdagger2app.manual.implementation.HelloWorldCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
internal abstract class HelloWorldModule {
    @Binds
    @IntoSet
    abstract fun helloWorldCommand(command: HelloWorldCommand?): Command?
}