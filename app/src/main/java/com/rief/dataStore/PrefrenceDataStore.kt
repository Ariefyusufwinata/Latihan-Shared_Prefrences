package com.rief.dataStore

import android.content.Context
import android.content.SharedPreferences

class PrefrenceDataStore (context : Context) {

    private val PREFS_NAME = "PREFS_NAME"
    private var sharedPref : SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key : String, value : String) {
        editor.putString(key, value)
            .apply()
    }

    fun getString(key : String) : String? {
        return sharedPref.getString(key, null)
    }

    fun put(key : String, value : Boolean) {
        editor.putString(key, null)
            .apply()
    }

    fun getBoolean(key : String) : Boolean? {
        return sharedPref.getBoolean(key, false)
    }
}