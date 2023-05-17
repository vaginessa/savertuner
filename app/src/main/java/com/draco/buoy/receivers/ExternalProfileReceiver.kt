package com.draco.buoy.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.draco.buoy.R
import com.draco.buoy.repositories.profiles.Profile
import com.draco.buoy.repositories.profiles.ProfileManager
import com.draco.buoy.utils.BatterySaverManager

class ExternalProfileReceiver : BroadcastReceiver() {
    private lateinit var batterySaverManager: BatterySaverManager

    override fun onReceive(context: Context, intent: Intent) {
        batterySaverManager = BatterySaverManager(context)

        val profileName = intent.getStringExtra(KEY_PROFILE_NAME)

        profileName?.let {
            when (it) {
                context.getString(R.string.pref_profile_key_light) -> ProfileManager(context).current = Profile.LIGHT
                context.getString(R.string.pref_profile_key_moderate) -> ProfileManager(context).current = Profile.MODERATE
                context.getString(R.string.pref_profile_key_high) -> ProfileManager(context).current = Profile.HIGH
                context.getString(R.string.pref_profile_key_extreme) -> ProfileManager(context).current = Profile.EXTREME
            }
        }

        resultData = batterySaverManager.getConstantsString()
    }

    companion object {
        const val KEY_PROFILE_NAME = "profile_name"
    }
}