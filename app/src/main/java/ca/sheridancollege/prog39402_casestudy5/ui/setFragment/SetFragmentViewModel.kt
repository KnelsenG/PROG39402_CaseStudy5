package ca.sheridancollege.prog39402_casestudy5.ui.setFragment

import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ca.sheridancollege.prog39402_casestudy5.ext.avatar
import ca.sheridancollege.prog39402_casestudy5.ext.name
import ca.sheridancollege.prog39402_casestudy5.util.SingleLiveEvent
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class SetFragmentViewModel @Inject constructor(
        private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val name = ObservableField<String>(sharedPreferences.name)
    val picture = ObservableField<Any>(sharedPreferences.avatar)
    val pictureLocation = ObservableField<String>(sharedPreferences.avatar)

    val continueEventClick = SingleLiveEvent<Unit>()
    val cameraEventClick = SingleLiveEvent<Unit>()

    fun btnImageClick() {
        cameraEventClick.call()
    }

    fun btnContClick() {
        sharedPreferences.name = name.get()
        continueEventClick.call()
    }

    fun updateImage(
            pic: Bitmap,
            out: FileOutputStream?,
            path: String
    ){

        val result = pic.compress(
                Bitmap.CompressFormat.JPEG
                , 100
                , out
        )

        if (result) {
            sharedPreferences.avatar = path
            picture.set(path)
            pictureLocation.set(path)
        }
    }
}

