package com.ma.basloq.data.preferences

import java.io.File
import java.util.Properties


private val preferencesFile = File("basloq_preferences.properties")
private val properties = Properties()


actual fun PlatformContext.putInt(key: String, value: Int) {
    properties.setProperty(key, value.toString())
    savePreferences()
}

actual fun PlatformContext.getInt(key: String, default: Int): Int {
    return properties.getProperty(key)?.toIntOrNull() ?: default
}

actual fun PlatformContext.putString(key: String, value: String) {
    properties.setProperty(key, value)
    savePreferences()
}

actual fun PlatformContext.getString(key: String): String? {
    return properties.getProperty(key)
}

actual fun PlatformContext.putBool(key: String, value: Boolean) {
    properties.setProperty(key, value.toString())
    savePreferences()
}

actual fun PlatformContext.getBool(key: String, default: Boolean): Boolean {
    return properties.getProperty(key)?.toBoolean() ?: default
}

private fun savePreferences() {
    properties.store(preferencesFile.outputStream(), null)
}