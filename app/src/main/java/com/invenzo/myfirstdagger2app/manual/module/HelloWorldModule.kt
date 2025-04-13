package com.invenzo.myfirstdagger2app.manual.module

import com.invenzo.myfirstdagger2app.manual.implementation.HelloWorldCommand
import com.invenzo.myfirstdagger2app.manual.interfaces.Command
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
internal abstract class HelloWorldModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract fun helloWorldCommand(command: HelloWorldCommand?): Command?
}