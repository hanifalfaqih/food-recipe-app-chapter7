package com.allana.food_recipe_app_chapter7.data.local.preference

import android.content.Context
import android.content.SharedPreferences
import com.allana.food_recipe_app_chapter7.data.model.response.auth.User
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.Exception
import javax.inject.Inject

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SessionPreference @Inject constructor(
    @ApplicationContext val context: Context,
val gson: Gson) {
    private var preference: SharedPreferences = context.getSharedPreferences(NAME, MODE)

    companion object {
        private const val NAME = "FOOD_RECIPE" //app name or else
        private const val MODE = Context.MODE_PRIVATE
        private val PREF_IS_APP_OPENED_FIRST_TIME = Pair("PREF_IS_APP_OPENED_FIRST_TIME", true)
        private val PREF_AUTH_TOKEN = Pair("PREF_AUTH_TOKEN", null)
        private val PREF_USER_DATA = Pair("PREF_USER_DATA", null)
    }

    var isAppOpenedFirstTime: Boolean
        get() = preference.getBoolean(
            PREF_IS_APP_OPENED_FIRST_TIME.first,
            PREF_IS_APP_OPENED_FIRST_TIME.second
        )
        set(value) = preference.edit {
            it.putBoolean(PREF_IS_APP_OPENED_FIRST_TIME.first, value)
        }

    var authToken:String?
    get() = preference.getString(PREF_AUTH_TOKEN.first,PREF_AUTH_TOKEN.second)
    set(value) = preference.edit {
        it.putString(PREF_AUTH_TOKEN.first, value)
    }

    var user: User?
    get() =
        try {
            gson.fromJson(
                preference.getString(PREF_USER_DATA.first,PREF_AUTH_TOKEN.second),
                User::class.java
            )
        }catch (e:Exception){
            null
        }
    set(value) = preference.edit {
        it.putString(PREF_USER_DATA.first, gson.toJson(value))
    }

    fun deleteSession(){
        preference.delete()
    }

}

private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = edit()
    operation(editor)
    editor.apply()
}

private fun SharedPreferences.delete() {
    edit().clear().apply()
}