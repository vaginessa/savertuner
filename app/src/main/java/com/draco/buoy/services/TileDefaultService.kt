package com.draco.buoy.services

import com.draco.buoy.repositories.profiles.Profile

class TileDefaultService : ProfileTileService() {
    override val profile = Profile.DEFAULT
}