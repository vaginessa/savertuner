package com.draco.buoy.services

import com.draco.buoy.repositories.profiles.Profile

class TileModerateService : ProfileTileService() {
    override val profile = Profile.MODERATE
}