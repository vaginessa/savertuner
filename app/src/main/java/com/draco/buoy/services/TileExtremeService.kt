package com.draco.buoy.services

import com.draco.buoy.repositories.profiles.Profile

class TileExtremeService : ProfileTileService() {
    override val profile = Profile.EXTREME
}