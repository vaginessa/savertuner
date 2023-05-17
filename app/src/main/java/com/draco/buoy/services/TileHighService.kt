package com.draco.buoy.services

import com.draco.buoy.repositories.profiles.Profile

class TileHighService : ProfileTileService() {
    override val profile = Profile.HIGH
}