package ca.sheridancollege.prog39402_casestudy5.di.module

import android.app.Application
import android.content.Context
import ca.sheridancollege.prog39402_casestudy5.di.module.viewmodel.ViewModelModule
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [
    ViewModelModule::class,
    SharedPreferencesModule::class
])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(application: Application): Context

}