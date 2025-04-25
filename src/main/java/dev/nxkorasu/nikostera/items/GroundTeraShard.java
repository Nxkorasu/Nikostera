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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Nullable;



import static dev.nxkorasu.nikostera.polymer.TeraObjects.BLANK_TERA_SHARD;

public class GroundTeraShard extends SimplePolymerItem {
    PolymerModelData modelData;
    public GroundTeraShard(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }
    boolean test = false;
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return super.getPolymerItem(itemStack,player);
    }
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        this.modelData = TeraObjects.groundTeraShardModelData;
        return this.modelData.value();
    }
    @Override
    public ActionResult useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        if(livingEntity instanceof PokemonEntity pokemonEntity){
            pokemonEntity.getPokemon().setTeraType(TeraTypes.getGROUND());
            ItemDeleter.deleteItemStack(playerEntity);
            playerEntity.sendMessage(Text.literal("Pokemon´s Teratype Changed to "+TeraTypes.getGROUND().getDisplayName()).formatted(Formatting.GREEN),true);
        }
        return ActionResult.PASS;
    }
}
