package dev.nxkorasu.nikostera.manager;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;

import java.util.Objects;

import static dev.nxkorasu.nikostera.polymer.TeraObjects.BLANK_TERA_SHARD;

public class ItemDeleter {
    public static void deleteItem(ItemUsageContext iuc){
        ItemStack mainHand = Objects.requireNonNull(iuc.getPlayer()).getMainHandStack();
        ItemStack offHand = Objects.requireNonNull(iuc.getPlayer()).getOffHandStack();
        if(!offHand.getItem().equals(BLANK_TERA_SHARD)){
            mainHand.decrement(1);
        }else{
            offHand.decrement(1);
        }
    }
    public static void deleteItemStack(PlayerEntity player){
        ItemStack mainHand = player.getMainHandStack();
        ItemStack offHand = player.getOffHandStack();
        if(!offHand.getItem().equals(BLANK_TERA_SHARD)){
            mainHand.decrement(1);
        }else{
            offHand.decrement(1);
        }
    }
}
