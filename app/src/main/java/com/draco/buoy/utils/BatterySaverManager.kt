package com.draco.buoy.utils

import android.content.ContentResolver
import android.content.Context
import android.provider.Settings
import com.draco.buoy.models.BatterySaverConstantsConfig
import com.draco.buoy.repositories.constants.BatterySaverSecureSettings
import com.draco.buoy.repositories.profiles.ProfileManager

class BatterySaverManager(private val context: Context) {
    private val contentResolver: ContentResolver = context.contentResolver

    /**
     * Return true if low power mode is enabled
     */
    fun getLowPower(): Boolean {
        return Settings.Global.getInt(
            contentResolver,
            BatterySaverSecureSettings.LOW_POWER,
            0
        ) == 1
    }

    /**
     * Enable or disable low power sticky mode
     */
    private fun setLowPowerSticky(state: Boolean) {
        val intBool = if (state) 1 else 0
        Settings.Global.putInt(
            contentResolver,
            BatterySaverSecureSettings.LOW_POWER_STICKY,
            intBool
        )
    }

    /**
     * Enable or disable low power sticky auto disable mode
     */
    private fun setLowPowerStickyAutoDisableEnabled(state: Boolean) {
        val intBool = if (state) 1 else 0
        Settings.Global.putInt(
            contentResolver,
            BatterySaverSecureSettings.LOW_POWER_STICKY_AUTO_DISABLE_ENABLED,
            intBool
        )
    }

    /**
     * Set the raw battery saver constants secure setting
     */
    private fun setConstantsString(constants: String?) {
        Settings.Global.putString(
            contentResolver,
            BatterySaverSecureSettings.BATTERY_SAVER_CONSTANTS,
            constants
        )
    }

    /**
     * Get the raw battery saver constants secure setting
     */
    fun getConstantsString(): String? {
        return Settings.Global.getString(
            contentResolver,
            BatterySaverSecureSettings.BATTERY_SAVER_CONSTANTS
        )
    }

    fun apply(config: BatterySaverConstantsConfig?, saveProfilePref: Boolean = true) {
        config?.let {
            setLowPowerSticky(true)
            setLowPowerStickyAutoDisableEnabled(false)
            setConstantsString(config.toString())
        } ?: run {
            setLowPowerSticky(false)
            setLowPowerStickyAutoDisableEnabled(true)
            setConstantsString(null)
        }
        if (saveProfilePref) {
            ProfileManager(context).setConfig(config)
        }
    }
}