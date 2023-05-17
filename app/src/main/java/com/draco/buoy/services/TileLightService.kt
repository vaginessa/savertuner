package com.draco.buoy.services

import com.draco.buoy.repositories.profiles.Profile

class TileLightService : ProfileTileService() {
    override val profile = Profile.LIGHT
}