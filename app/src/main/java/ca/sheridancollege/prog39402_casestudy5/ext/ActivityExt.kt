package ca.sheridancollege.prog39402_casestudy5.ext

import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.QuickToast(msg: String) = android.widget.Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
