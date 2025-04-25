package dev.nxkorasu.nikostera.items;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import dev.nxkorasu.nikostera.manager.ItemDeleter;
import dev.nxkorasu.nikostera.polymer.TeraObjects;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static dev.nxkorasu.nikostera.polymer.TeraObjects.*;

public class BlankTeraShard extends SimplePolymerItem {
    PolymerModelData modelData;
    public BlankTeraShard(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }
    boolean test = false;
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return super.getPolymerItem(itemStack,player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        this.modelData = blankTeraShardModelData;
        return this.modelData.value();
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext) {
        Block block = itemUsageContext.getWorld().getBlockState(itemUsageContext.getBlockPos()).getBlock();
        PlayerEntity player = Objects.requireNonNull(itemUsageContext.getPlayer());
        ItemStack heldStack = Objects.requireNonNull(itemUsageContext.getPlayer()).getMainHandStack();
        ItemStack offHand = Objects.requireNonNull(itemUsageContext.getPlayer()).getOffHandStack();
        if(!offHand.getItem().equals(BLANK_TERA_SHARD) || !heldStack.getItem().equals(BLANK_TERA_SHARD)){
            if(block == Blocks.WHEAT){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(GRASS_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.MAGMA_BLOCK){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(FIRE_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.BEEHIVE){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(BUG_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.POWDER_SNOW){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(ICE_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.REINFORCED_DEEPSLATE){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(DARK_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.BEDROCK){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(ROCK_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.ENDER_CHEST){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(DRAGON_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.COPPER_BLOCK){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(ELECTRIC_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.MUD){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(GROUND_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.POTATOES){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(POISON_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.SOUL_SAND){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(GHOST_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.BAMBOO_BLOCK){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(FIGHTING_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.WET_SPONGE){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(WATER_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.ENCHANTING_TABLE){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(PSYCHIC_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.GLASS && player.getBlockY() >= 100){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(FLYING_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.AMETHYST_BLOCK){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(FAIRY_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
            if(block == Blocks.IRON_BLOCK){
                ItemDeleter.deleteItem(itemUsageContext);
                player.giveItemStack(new ItemStack(STEEL_TERA_SHARD));
                return ActionResult.SUCCESS;
            }
        }else{
            player.sendMessage(Text.literal("An Error Occurred, please hold only the Blank Tera Shard").formatted(Formatting.RED),true);
        }
        ItemDeleter.deleteItem(itemUsageContext);
        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(entity instanceof PokemonEntity pokemonEntity && pokemonEntity.getExposedSpecies().getName().equalsIgnoreCase("terapagos")){
            user.giveItemStack(new ItemStack(STELLAR_TERA_SHARD,1));
            ItemDeleter.deleteItemStack(user);
        }
        return ActionResult.PASS;
    }
}
