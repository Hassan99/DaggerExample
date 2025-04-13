package com.invenzo.myfirstdagger2app.manual.module

import com.invenzo.myfirstdagger2app.manual.interfaces.Outputter
import dagger.Module
import dagger.Provides

@Module
internal object SystemOutModule {
    @Provides
    fun textOutputter(): Outputter {
        return Outputter { x: String? -> println(x) }
    }
}