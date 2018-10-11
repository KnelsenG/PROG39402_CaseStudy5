package ca.sheridancollege.prog39402_casestudy5.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences = context.applicationContext.getSharedPreferences("prefs", Context.MODE_PRIVATE)!!
}
