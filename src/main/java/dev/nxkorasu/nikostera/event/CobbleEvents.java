package dev.nxkorasu.nikostera.event;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;

public class CobbleEvents {
    public static void register(){
        //Each time a pokemon terastalizes, call the method
        CobblemonEvents.TERASTALLIZATION.subscribe(Priority.NORMAL, TeraGlowHandler::terrastallizationUsed);
        CobblemonEvents.POKEMON_SENT_POST.subscribe(Priority.NORMAL, TeraGlowHandler::switchIn);
        CobblemonEvents.BATTLE_FLED.subscribe(Priority.NORMAL,TeraGlowHandler::leaveBattle);
        CobblemonEvents.BATTLE_VICTORY.subscribe(Priority.NORMAL,TeraGlowHandler::winBattle);
        CobblemonEvents.POKEMON_CAPTURED.subscribe(Priority.NORMAL,TeraGlowHandler::capturedPokemon);
    }
}
