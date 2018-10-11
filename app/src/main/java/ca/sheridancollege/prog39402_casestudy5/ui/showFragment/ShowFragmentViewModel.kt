package ca.sheridancollege.prog39402_casestudy5.ui.showFragment

import android.content.SharedPreferences
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ca.sheridancollege.prog39402_casestudy5.ext.avatar
import ca.sheridancollege.prog39402_casestudy5.ext.name
import javax.inject.Inject

class ShowFragmentViewModel @Inject constructor(
        private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val name = ObservableField<String>(sharedPreferences.name)
    val picture = ObservableField<Any>(sharedPreferences.avatar)

}

