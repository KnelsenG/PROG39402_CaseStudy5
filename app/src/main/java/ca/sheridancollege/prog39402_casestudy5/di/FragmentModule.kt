package ca.sheridancollege.prog39402_casestudy5.di

import ca.sheridancollege.prog39402_casestudy5.ui.setFragment.SetFragment
import ca.sheridancollege.prog39402_casestudy5.ui.showFragment.ShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindSetFragment(): SetFragment

    @ContributesAndroidInjector
    abstract fun bindShowFragment(): ShowFragment

}
