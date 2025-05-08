package dev.nxkorasu.nikostera.event;

import com.cobblemon.mod.common.api.events.battles.BattleFledEvent;
import com.cobblemon.mod.common.api.events.battles.BattleVictoryEvent;
import com.cobblemon.mod.common.api.events.battles.instruction.TerastallizationEvent;
import com.cobblemon.mod.common.api.events.pokemon.PokemonCapturedEvent;
import com.cobblemon.mod.common.api.events.pokemon.PokemonSentPostEvent;
import com.cobblemon.mod.common.api.pokemon.feature.FlagSpeciesFeature;
import com.cobblemon.mod.common.api.pokemon.feature.StringSpeciesFeature;
import com.cobblemon.mod.common.api.types.tera.TeraType;
import com.cobblemon.mod.common.api.types.tera.TeraTypes;
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kotlin.Unit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Formatting;

import java.util.List;
import java.util.UUID;

public class TeraGlowHandler {
    public static Unit terrastallizationUsed(TerastallizationEvent terastallizationEvent) {
        //Obtain the Entity and Pokemon Affected
        LivingEntity pokemon = terastallizationEvent.getPokemon().getEffectedPokemon().getEntity();
        Pokemon pk = terastallizationEvent.getPokemon().getEffectedPokemon();
        //Change the pokemon if needed
        if (pk.getSpecies().getName().equals("Terapagos")) {
            new StringSpeciesFeature("tera_form", "stellar").apply(pk);
        }
        if (pk.getSpecies().getName().equals("Ogerpon")) {
            new FlagSpeciesFeature("embody_aspect", true).apply(pk);
        }
        //Obtain the Pokemon´s World, create a team and give it a color though formatting
        if (pokemon.getWorld() instanceof ServerWorld serverLevel) {
            ServerScoreboard scoreboard = serverLevel.getScoreboard();
            String teamName = "glow_" + UUID.randomUUID().toString().substring(0, 8);

            Team team = scoreboard.getTeam(teamName);

            Formatting color = getGlowColorForTeraType(terastallizationEvent.getPokemon().getEffectedPokemon().getTeraType());
            if (team == null) {
                team = scoreboard.addTeam(teamName);
                team.setColor(color);
            }
            scoreboard.addScoreHolderToTeam(pokemon.getUuid().toString(), team);
            //Give the pokemon a barrier as last flower fed for control reasons
            pk.setLastFlowerFed(new ItemStack(Items.BARRIER, 1));
            //Apply the glowing effect to the Entity
            pokemon.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, Integer.MAX_VALUE, 0));
        }
        return Unit.INSTANCE;
    }
    //Determines what color will the team have depending on the pokemon´s teratype
    public static Formatting getGlowColorForTeraType(TeraType teratype) {
        Formatting teratypeColor;
        switch (teratype.getDisplayName().getString().toLowerCase()) {
            case "fire" -> teratypeColor = Formatting.RED;
            case "water" -> teratypeColor = Formatting.BLUE;
            case "electric" -> teratypeColor = Formatting.YELLOW;
            case "grass" -> teratypeColor = Formatting.GREEN;
            case "ice", "flying" -> teratypeColor = Formatting.AQUA;
            case "fighting" -> teratypeColor = Formatting.DARK_RED;
            case "poison" -> teratypeColor = Formatting.DARK_PURPLE;
            case "ground" -> teratypeColor = Formatting.GOLD;
            case "psychic", "fairy" -> teratypeColor = Formatting.LIGHT_PURPLE;
            case "bug" -> teratypeColor = Formatting.DARK_GREEN;
            case "rock" -> teratypeColor = Formatting.GRAY;
            case "ghost" -> teratypeColor = Formatting.DARK_GRAY;
            case "dragon" -> teratypeColor = Formatting.DARK_BLUE;
            case "dark" -> teratypeColor = Formatting.BLACK;
            case "steel" -> teratypeColor = Formatting.DARK_AQUA;
            default -> teratypeColor = Formatting.WHITE;
        }
        return teratypeColor;
    }

    public static Unit switchIn(PokemonSentPostEvent pokemonSentPostEvent) {
        LivingEntity pokemon = pokemonSentPostEvent.getPokemon().getEntity();
        Pokemon pk = pokemonSentPostEvent.getPokemon();
        //If the pokemon has a barrier on its last flower fed slot, give it glow
        if (pokemonSentPostEvent.getPokemon().getLastFlowerFed().getItem().equals(Items.BARRIER)) {
            if (pokemon.getWorld() instanceof ServerWorld serverLevel) {
                ServerScoreboard scoreboard = serverLevel.getScoreboard();
                String teamName = "glow_" + UUID.randomUUID().toString().substring(0, 8);

                Team team = scoreboard.getTeam(teamName);

                Formatting color = getGlowColorForTeraType(pokemonSentPostEvent.getPokemon().getTeraType());
                if (team == null) {
                    team = scoreboard.addTeam(teamName);
                    team.setColor(color);
                }
                scoreboard.addScoreHolderToTeam(pokemon.getUuid().toString(), team);
                if (pk.getSpecies().getName().equalsIgnoreCase("terapagos")) {
                    new StringSpeciesFeature("tera_form", "terastal").apply(pk);
                }
                if (pk.getSpecies().getName().equalsIgnoreCase("ogerpon")) {
                    new FlagSpeciesFeature("embody_aspect", false).apply(pk);
                }
                pokemon.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, Integer.MAX_VALUE, 0));
            }
        }
        return Unit.INSTANCE;
    }

    public static Unit leaveBattle(BattleFledEvent battleFledEvent) {
        //clear the lastflowerfed on fleed
        clearFlowers(battleFledEvent.getPlayer().getPokemonList());
        return Unit.INSTANCE;
    }
    public static void clearFlowers(List<BattlePokemon> team){
        //Just clear the last fed flower slot for each pokemon
        for (BattlePokemon pokemon : team) {
            pokemon.getEffectedPokemon().setLastFlowerFed(new ItemStack(Items.AIR,1));
            if (pokemon.getEffectedPokemon().getSpecies().getName().equals("Terapagos")) {
                new StringSpeciesFeature("tera_form", "terastal").apply(pokemon.getOriginalPokemon());
            }
            if (pokemon.getEffectedPokemon().getSpecies().getName().equals("Ogerpon")) {
                new FlagSpeciesFeature("embody_aspect", false).apply(pokemon.getOriginalPokemon());
            }
        }
    }

    public static Unit winBattle(BattleVictoryEvent battleVictoryEvent) {
        //clear the lastflowerfed when a battle ends, on both sides
        clearFlowers(battleVictoryEvent.getWinners().getFirst().getPokemonList());
        clearFlowers(battleVictoryEvent.getLosers().getFirst().getPokemonList());
        return Unit.INSTANCE;
    }

    public static Unit capturedPokemon(PokemonCapturedEvent pokemonCapturedEvent) {
        //if terapagos or ogerpon are captured, set their apropied teratypes
        if(pokemonCapturedEvent.getPokemon().getSpecies().getName().equalsIgnoreCase("ogerpon")){
            pokemonCapturedEvent.getPokemon().setTeraType(TeraTypes.getGRASS());
        }
        if(pokemonCapturedEvent.getPokemon().getSpecies().getName().equalsIgnoreCase("terapagos")){
            pokemonCapturedEvent.getPokemon().setTeraType(TeraTypes.getSTELLAR());
        }
        return Unit.INSTANCE;
    }
}
