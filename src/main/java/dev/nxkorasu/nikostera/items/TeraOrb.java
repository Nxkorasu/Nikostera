package dev.nxkorasu.nikostera.items;

import com.cobblemon.mod.common.Cobblemon;
import dev.nxkorasu.nikostera.polymer.TeraObjects;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TeraOrb extends SimplePolymerItem {
    PolymerModelData modelData;
    public TeraOrb(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }
    boolean test = false;
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return super.getPolymerItem(itemStack,player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        this.modelData = TeraObjects.teraorbModelData;
        return this.modelData.value();
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(Cobblemon.playerDataManager.getGenericData(playerEntity.getUuid()).getKeyItems().remove(Identifier.of("cobblemon:tera_orb"))){
            playerEntity.sendMessage(Text.literal("You disabled the ability to Terastalize").formatted(Formatting.RED),true);
            return TypedActionResult.fail(playerEntity.getStackInHand(hand));
        }
        else {
            Cobblemon.playerDataManager.getGenericData(playerEntity.getUuid()).getKeyItems().add(Identifier.of("cobblemon:tera_orb"));
            playerEntity.sendMessage(Text.literal("You activated the ability to Terastalize!").formatted(Formatting.GREEN),true);
            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        }
    }}
