package com.draco.buoy.repositories.profiles

import android.content.Context
import androidx.preference.PreferenceManager
import com.draco.buoy.models.BatterySaverConstantsConfig
import com.draco.buoy.utils.BatterySaverManager

enum class Profile {
    LIGHT,
    MODERATE,
    HIGH,
    EXTREME,
    DEFAULT
}

class ProfileManager(context: Context) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    private val batterySaverManager = BatterySaverManager(context)

    private fun getPref(key: String): BatterySaverConstantsConfig? {
        return prefs.getString(key, null)?.let {
            BatterySaverConstantsConfig().apply {
                import(it)
            }
        }
    }

    private fun setPref(key: String, value: BatterySaverConstantsConfig?) {
        prefs.edit().apply{
            value?.let {
                putString(key, value.toString())
            } ?: remove(key)
        }.apply()
    }

    private var light: BatterySaverConstantsConfig?
        get() = getPref(LIGHT) ?: BatterySaverConstantsConfigProfiles.LIGHT
        set(value) = setPref(LIGHT, value)

    private var moderate: BatterySaverConstantsConfig?
        get() = getPref(MODERATE) ?: BatterySaverConstantsConfigProfiles.MODERATE
        set(value) = setPref(MODERATE, value)

    private var high: BatterySaverConstantsConfig?
        get() = getPref(HIGH) ?: BatterySaverConstantsConfigProfiles.HIGH
        set(value) = setPref(HIGH, value)

    private var extreme: BatterySaverConstantsConfig?
        get() = getPref(EXTREME) ?: BatterySaverConstantsConfigProfiles.EXTREME
        set(value) = setPref(EXTREME, value)

    var current: Profile
        get() = prefs.getString(CURRENT_PROFILE, null)?.let { Profile.valueOf(it) } ?: Profile.DEFAULT
        set(value) {
            prefs.edit().putString(CURRENT_PROFILE, value.toString()).apply()
            batterySaverManager.apply(
                when (value) {
                    Profile.LIGHT -> light!!
                    Profile.MODERATE -> moderate!!
                    Profile.HIGH -> high!!
                    Profile.EXTREME -> extreme!!
                    else -> null
                },
                saveProfilePref = false
            )
        }

    fun setConfig(config: BatterySaverConstantsConfig?) {
        when (current) {
            Profile.LIGHT -> light = config
            Profile.MODERATE -> moderate = config
            Profile.HIGH -> high = config
            Profile.EXTREME -> extreme = config
            else -> {}
        }
    }

    companion object {
        const val PREF_PREFIX = "com.draco.buoy.repositories.profiles.ProfileManager"
        const val CURRENT_PROFILE = "$PREF_PREFIX#CURRENT_PROFILE"
        private const val LIGHT = "$PREF_PREFIX#LIGHT"
        private const val MODERATE = "$PREF_PREFIX#MODERATE"
        private const val HIGH = "$PREF_PREFIX#HIGH"
        private const val EXTREME = "$PREF_PREFIX#EXTREME"
    }
}