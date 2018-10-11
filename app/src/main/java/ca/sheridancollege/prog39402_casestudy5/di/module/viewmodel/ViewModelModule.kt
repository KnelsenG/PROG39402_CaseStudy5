package ca.sheridancollege.prog39402_casestudy5.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.sheridancollege.prog39402_casestudy5.ui.setFragment.SetFragmentViewModel
import ca.sheridancollege.prog39402_casestudy5.ui.mainActivity.MainActivityViewModel
import ca.sheridancollege.prog39402_casestudy5.ui.showFragment.ShowFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SetFragmentViewModel::class)
    abstract fun bindSetFragmentViewModel(viewModel: SetFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowFragmentViewModel::class)
    abstract fun bindShowFragmentViewModel(viewModel: ShowFragmentViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
