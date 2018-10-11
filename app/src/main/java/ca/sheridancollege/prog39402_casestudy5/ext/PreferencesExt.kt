package ca.sheridancollege.prog39402_casestudy5.ext

import android.content.SharedPreferences
import androidx.core.content.edit

internal var SharedPreferences.avatar: String?
    set(value) {
        edit { putString("avatar", value) }
    }
    get() {
        return getString("avatar", "")
    }

internal var SharedPreferences.name: String?
    set(value) {
        edit { putString("name", value) }
    }
    get() {
        return getString("name", "")
    }