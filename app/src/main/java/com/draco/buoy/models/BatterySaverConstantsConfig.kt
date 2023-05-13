package com.draco.buoy.models

import android.os.Build
import com.draco.buoy.repositories.constants.BatterySaverConstants31
import com.draco.buoy.repositories.constants.BatterySaverConstants32
import com.draco.buoy.repositories.constants.PowerManagerLocationModes

data class BatterySaverConstantsConfig(
    var advertiseIsEnabled: Boolean =       true,
    var dataSaverDisabled: Boolean =        true,
    var enableNightMode: Boolean =          true,
    var launchBoostDisabled: Boolean =      true,
    var vibrationDisabled: Boolean =        true,
    var animationDisabled: Boolean =        false,
    var soundTriggerDisabled: Boolean =     true,
    var fullBackupDeferred: Boolean =       true,
    var keyValueBackupDeferred: Boolean =   true,
    var fireWallDisabled: Boolean =         true,
    var gpsMode: Int =                      PowerManagerLocationModes.ALL_DISABLED_SCREEN_OFF,
    var adjustBrightnessDisabled: Boolean = true,
    var adjustBrightnessFactor: Float =     0.5f,
    var forceAllAppsStandby: Boolean =      true,
    var forceBackgroundCheck: Boolean =     true,
    var optionalSensorsDisabled: Boolean =  true,
    var aodDisabled: Boolean =              true,
    var quickDozeEnabled: Boolean =         true
) {
    override fun toString(): String {
        return if (Build.VERSION.SDK_INT < 32) { toString31() } else { toString32() }
    }

    private fun toString31(): String {
        return  "${BatterySaverConstants31.ADVERTISE_IS_ENABLED}=$advertiseIsEnabled," +
                "${BatterySaverConstants31.DATASAVER_DISABLED}=$dataSaverDisabled," +
                "${BatterySaverConstants31.ENABLE_NIGHT_MODE}=$enableNightMode," +
                "${BatterySaverConstants31.LAUNCH_BOOST_DISABLED}=$launchBoostDisabled," +
                "${BatterySaverConstants31.VIBRATION_DISABLED}=$vibrationDisabled," +
                "${BatterySaverConstants31.ANIMATION_DISABLED}=$animationDisabled," +
                "${BatterySaverConstants31.SOUNDTRIGGER_DISABLED}=$soundTriggerDisabled," +
                "${BatterySaverConstants31.FULLBACKUP_DEFERRED}=$fullBackupDeferred," +
                "${BatterySaverConstants31.KEYVALUEBACKUP_DEFERRED}=$keyValueBackupDeferred," +
                "${BatterySaverConstants31.FIREWALL_DISABLED}=$fireWallDisabled," +
                "${BatterySaverConstants31.GPS_MODE}=$gpsMode," +
                "${BatterySaverConstants31.ADJUST_BRIGHTNESS_DISABLED}=$adjustBrightnessDisabled," +
                "${BatterySaverConstants31.ADJUST_BRIGHTNESS_FACTOR}=$adjustBrightnessFactor," +
                "${BatterySaverConstants31.FORCE_ALL_APPS_STANDBY}=$forceAllAppsStandby," +
                "${BatterySaverConstants31.FORCE_BACKGROUND_CHECK}=$forceBackgroundCheck," +
                "${BatterySaverConstants31.OPTIONAL_SENSORS_DISABLED}=$optionalSensorsDisabled," +
                "${BatterySaverConstants31.AOD_DISABLED}=$aodDisabled," +
                "${BatterySaverConstants31.QUICK_DOZE_ENABLED}=$quickDozeEnabled"
    }

    private fun toString32(): String {
        return  "${BatterySaverConstants32.ADVERTISE_IS_ENABLED}=$advertiseIsEnabled," +
                "${BatterySaverConstants32.ENABLE_DATASAVER}=${!dataSaverDisabled}," +
                "${BatterySaverConstants32.ENABLE_NIGHT_MODE}=$enableNightMode," +
                "${BatterySaverConstants32.DISABLE_LAUNCH_BOOST}=$launchBoostDisabled," +
                "${BatterySaverConstants32.DISABLE_VIBRATION}=$vibrationDisabled," +
                "${BatterySaverConstants32.DISABLE_ANIMATION}=$animationDisabled," +
                "${BatterySaverConstants32.DISABLE_SOUNDTRIGGER}=$soundTriggerDisabled," +
                "${BatterySaverConstants32.DEFER_FULL_BACKUP}=$fullBackupDeferred," +
                "${BatterySaverConstants32.DEFER_KEYVALUE_BACKUP}=$keyValueBackupDeferred," +
                "${BatterySaverConstants32.ENABLE_FIREWALL}=${!fireWallDisabled}," +
                "${BatterySaverConstants32.LOCATION_MODE}=$gpsMode," +
                "${BatterySaverConstants32.ENABLE_BRIGHTNESS_ADJUSTMENT}=${!adjustBrightnessDisabled}," +
                "${BatterySaverConstants32.ADJUST_BRIGHTNESS_FACTOR}=$adjustBrightnessFactor," +
                "${BatterySaverConstants32.FORCE_ALL_APPS_STANDBY}=$forceAllAppsStandby," +
                "${BatterySaverConstants32.FORCE_BACKGROUND_CHECK}=$forceBackgroundCheck," +
                "${BatterySaverConstants32.DISABLE_OPTIONAL_SENSORS}=$optionalSensorsDisabled," +
                "${BatterySaverConstants32.DISABLE_AOD}=$aodDisabled," +
                "${BatterySaverConstants32.ENABLE_QUICK_DOZE}=$quickDozeEnabled"
    }

    fun import(string: String) {
        val keyValueMap = string.split(",").associate {
            val (key, value) = it.split("=")
            key to value
        }

        for ((key, value) in keyValueMap) {
            when (key) {
                BatterySaverConstants31.ADVERTISE_IS_ENABLED -> advertiseIsEnabled = value.toBoolean()
                BatterySaverConstants31.DATASAVER_DISABLED -> dataSaverDisabled = value.toBoolean()
                BatterySaverConstants31.ENABLE_NIGHT_MODE -> enableNightMode = value.toBoolean()
                BatterySaverConstants31.LAUNCH_BOOST_DISABLED -> launchBoostDisabled = value.toBoolean()
                BatterySaverConstants31.VIBRATION_DISABLED -> vibrationDisabled = value.toBoolean()
                BatterySaverConstants31.ANIMATION_DISABLED -> animationDisabled = value.toBoolean()
                BatterySaverConstants31.SOUNDTRIGGER_DISABLED -> soundTriggerDisabled = value.toBoolean()
                BatterySaverConstants31.FULLBACKUP_DEFERRED -> fullBackupDeferred = value.toBoolean()
                BatterySaverConstants31.KEYVALUEBACKUP_DEFERRED -> keyValueBackupDeferred = value.toBoolean()
                BatterySaverConstants31.FIREWALL_DISABLED -> fireWallDisabled = value.toBoolean()
                BatterySaverConstants31.GPS_MODE -> gpsMode = value.toInt()
                BatterySaverConstants31.ADJUST_BRIGHTNESS_DISABLED -> adjustBrightnessDisabled = value.toBoolean()
                BatterySaverConstants31.ADJUST_BRIGHTNESS_FACTOR -> adjustBrightnessFactor = value.toFloat()
                BatterySaverConstants31.FORCE_ALL_APPS_STANDBY -> forceAllAppsStandby = value.toBoolean()
                BatterySaverConstants31.FORCE_BACKGROUND_CHECK -> forceBackgroundCheck = value.toBoolean()
                BatterySaverConstants31.OPTIONAL_SENSORS_DISABLED -> optionalSensorsDisabled = value.toBoolean()
                BatterySaverConstants31.AOD_DISABLED -> aodDisabled = value.toBoolean()
                BatterySaverConstants31.QUICK_DOZE_ENABLED -> quickDozeEnabled = value.toBoolean()
                BatterySaverConstants32.ADVERTISE_IS_ENABLED -> advertiseIsEnabled = value.toBoolean()
                BatterySaverConstants32.ENABLE_DATASAVER -> dataSaverDisabled = !value.toBoolean()
                BatterySaverConstants32.ENABLE_NIGHT_MODE -> enableNightMode = value.toBoolean()
                BatterySaverConstants32.DISABLE_LAUNCH_BOOST -> launchBoostDisabled = value.toBoolean()
                BatterySaverConstants32.DISABLE_VIBRATION -> vibrationDisabled = value.toBoolean()
                BatterySaverConstants32.DISABLE_ANIMATION -> animationDisabled = value.toBoolean()
                BatterySaverConstants32.DISABLE_SOUNDTRIGGER -> soundTriggerDisabled = value.toBoolean()
                BatterySaverConstants32.DEFER_FULL_BACKUP -> fullBackupDeferred = value.toBoolean()
                BatterySaverConstants32.DEFER_KEYVALUE_BACKUP -> keyValueBackupDeferred = value.toBoolean()
                BatterySaverConstants32.ENABLE_FIREWALL -> fireWallDisabled = !value.toBoolean()
                BatterySaverConstants32.LOCATION_MODE -> gpsMode = value.toInt()
                BatterySaverConstants32.ENABLE_BRIGHTNESS_ADJUSTMENT -> adjustBrightnessDisabled = !value.toBoolean()
                BatterySaverConstants32.ADJUST_BRIGHTNESS_FACTOR -> adjustBrightnessFactor = value.toFloat()
                BatterySaverConstants32.FORCE_ALL_APPS_STANDBY -> forceAllAppsStandby = value.toBoolean()
                BatterySaverConstants32.FORCE_BACKGROUND_CHECK -> forceBackgroundCheck = value.toBoolean()
                BatterySaverConstants32.DISABLE_OPTIONAL_SENSORS -> optionalSensorsDisabled = value.toBoolean()
                BatterySaverConstants32.DISABLE_AOD -> aodDisabled = value.toBoolean()
                BatterySaverConstants32.ENABLE_QUICK_DOZE -> quickDozeEnabled = value.toBoolean()
            }
        }
    }
}