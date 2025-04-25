package dev.nxkorasu.nikostera

import dev.nxkorasu.nikostera.event.CobbleEvents
import dev.nxkorasu.nikostera.polymer.TeraObjects
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils
import net.fabricmc.api.ModInitializer

class Nikostera : ModInitializer {

    val MOD_ID = "nikostera"

    override fun onInitialize() {
        println("Mod init")
        PolymerResourcePackUtils.markAsRequired()
        PolymerResourcePackUtils.addModAssets(MOD_ID)
        // Z-Crystals
        TeraObjects.requestModel()
        TeraObjects.registerItemGroup()
        CobbleEvents.register()
    }
}
