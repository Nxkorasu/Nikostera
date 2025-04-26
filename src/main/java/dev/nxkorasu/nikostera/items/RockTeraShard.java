package dev.nxkorasu.nikostera.items;

import com.cobblemon.mod.common.api.types.tera.TeraTypes;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.nxkorasu.nikostera.manager.ItemDeleter;
import dev.nxkorasu.nikostera.polymer.TeraObjects;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Nullable;

public class RockTeraShard extends SimplePolymerItem {
    PolymerModelData modelData;
    public RockTeraShard(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }
    boolean test = false;
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return super.getPolymerItem(itemStack,player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        this.modelData = TeraObjects.rockTeraShardModelData;
        return this.modelData.value();
    }
    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity){
            if(!pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("ogerpon") && !pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("terapagos")) {
                pokemonEntity.getPokemon().setTeraType(TeraTypes.getROCK());
                ItemDeleter.deleteItemStack(playerEntity);
                playerEntity.sendMessage(Text.literal("Pokemon´s Teratype Changed to " + TeraTypes.getROCK().getDisplayName()).formatted(Formatting.GREEN), true);
            }else{
                playerEntity.sendMessage(Text.literal("That pokemon is Unable to change Tera Type...").formatted(Formatting.RED), true);
            }
        }
        return ActionResult.PASS;
    }
}
