package ca.sheridancollege.prog39402_casestudy5.ext

import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageButton
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import ca.sheridancollege.prog39402_casestudy5.R

@BindingAdapter("imageButtonBitmap")
fun imageButtonBitmap(imageButton: ImageButton, source: Any?) {
    if (source != null) {
        when (source) {
            is String -> imageButton.setImageURI(Uri.parse(source))
            is Uri -> imageButton.setImageURI(source)
            is Bitmap -> imageButton.setImageBitmap(source)
        }
    } else {
        imageButton.setImageResource(R.drawable.avatar)
    }
}
@BindingAdapter("imageViewBitmap")
fun imageViewBitmap(imageView: ImageView, source: Any?) {
    if (source != null) {
        when (source) {
            is String -> imageView.setImageURI(Uri.parse(source))
            is Uri -> imageView.setImageURI(source)
            is Bitmap -> imageView.setImageBitmap(source)
        }
    } else {
        imageView.setImageResource(R.drawable.avatar)
    }
}