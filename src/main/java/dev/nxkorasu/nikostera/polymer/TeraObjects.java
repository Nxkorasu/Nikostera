package dev.nxkorasu.nikostera.polymer;

import dev.nxkorasu.nikostera.Nikostera;
import dev.nxkorasu.nikostera.items.*;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class TeraObjects {
    static final String MOD_ID = "nikostera";
    private static final Item.Settings itemSettings = new Item.Settings().maxCount(1).rarity(Rarity.EPIC);
    private static final Item baseVanillaItem = Items.AMETHYST_SHARD;
    public static PolymerModelData teraorbModelData,
            normalTeraShardModelData,
            blankTeraShardModelData,
            fireTeraShardModelData,
            waterTeraShardModelData,
            grassTeraShardModelData,
            electricTeraShardModelData,
            iceTeraShardModelData,
            fightingTeraShardModelData,
            poisonTeraShardModelData,
            groundTeraShardModelData,
            flyingTeraShardModelData,
            psychicTeraShardModelData,
            bugTeraShardModelData,
            rockTeraShardModelData,
            ghostTeraShardModelData,
            dragonTeraShardModelData,
            darkTeraShardModelData,
            steelTeraShardModelData,
            fairyTeraShardModelData,
            stellarTeraShardModelData;

    public static final TeraOrb TERA_ORB = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "tera_orb"),
            new TeraOrb(itemSettings, baseVanillaItem));
    public static final BlankTeraShard BLANK_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "blank_tera_shard"),
            new BlankTeraShard(itemSettings, baseVanillaItem));
    public static final NormalTeraShard NORMAL_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "normal_tera_shard"),
            new NormalTeraShard(itemSettings, baseVanillaItem));
    public static final FireTeraShard FIRE_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "fire_tera_shard"),
            new FireTeraShard(itemSettings, baseVanillaItem));
    public static final WaterTeraShard WATER_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "water_tera_shard"),
            new WaterTeraShard(itemSettings, baseVanillaItem));
    public static final GrassTeraShard GRASS_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "grass_tera_shard"),
            new GrassTeraShard(itemSettings, baseVanillaItem));
    public static final ElectricTeraShard ELECTRIC_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "electric_tera_shard"),
            new ElectricTeraShard(itemSettings, baseVanillaItem));
    public static final IceTeraShard ICE_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "ice_tera_shard"),
            new IceTeraShard(itemSettings, baseVanillaItem));
    public static final FightingTeraShard FIGHTING_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "fighting_tera_shard"),
            new FightingTeraShard(itemSettings, baseVanillaItem));
    public static final PoisonTeraShard POISON_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "poison_tera_shard"),
            new PoisonTeraShard(itemSettings, baseVanillaItem));
    public static final GroundTeraShard GROUND_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "ground_tera_shard"),
            new GroundTeraShard(itemSettings, baseVanillaItem));
    public static final FlyingTeraShard FLYING_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "flying_tera_shard"),
            new FlyingTeraShard(itemSettings, baseVanillaItem));
    public static final PsychicTeraShard PSYCHIC_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "psychic_tera_shard"),
            new PsychicTeraShard(itemSettings, baseVanillaItem));
    public static final BugTeraShard BUG_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "bug_tera_shard"),
            new BugTeraShard(itemSettings, baseVanillaItem));
    public static final RockTeraShard ROCK_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "rock_tera_shard"),
            new RockTeraShard(itemSettings, baseVanillaItem));
    public static final GhostTeraShard GHOST_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "ghost_tera_shard"),
            new GhostTeraShard(itemSettings, baseVanillaItem));
    public static final DragonTeraShard DRAGON_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "dragon_tera_shard"),
            new DragonTeraShard(itemSettings, baseVanillaItem));
    public static final DarkTeraShard DARK_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "dark_tera_shard"),
            new DarkTeraShard(itemSettings, baseVanillaItem));
    public static final SteelTeraShard STEEL_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "steel_tera_shard"),
            new SteelTeraShard(itemSettings, baseVanillaItem));
    public static final FairyTeraShard FAIRY_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "fairy_tera_shard"),
            new FairyTeraShard(itemSettings, baseVanillaItem));
    public static final StellarTeraShard STELLAR_TERA_SHARD = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "stellar_tera_shard"),
            new StellarTeraShard(itemSettings, baseVanillaItem));


    public static void requestModel(){
        teraorbModelData = PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/tera_orb"));
        normalTeraShardModelData = PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/normal_tera_shard"));
        blankTeraShardModelData = PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/blank_tera_shard"));
        fireTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/fire_tera_shard"));
        waterTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/water_tera_shard"));
        grassTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/grass_tera_shard"));
        electricTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/electric_tera_shard"));
        iceTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/ice_tera_shard"));
        fightingTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/fighting_tera_shard"));
        poisonTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/poison_tera_shard"));
        groundTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/ground_tera_shard"));
        flyingTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/flying_tera_shard"));
        psychicTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/psychic_tera_shard"));
        bugTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/bug_tera_shard"));
        rockTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/rock_tera_shard"));
        ghostTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/ghost_tera_shard"));
        dragonTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/dragon_tera_shard"));
        darkTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/dark_tera_shard"));
        steelTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/steel_tera_shard"));
        fairyTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/fairy_tera_shard"));
        stellarTeraShardModelData= PolymerResourcePackUtils.requestModel(baseVanillaItem, Identifier.of(MOD_ID, "item/stellar_tera_shard"));
    }
    public static final ItemGroup TERA_OBJECTS = FabricItemGroup.builder()
            .icon(TERA_ORB::getDefaultStack)
            .displayName(Text.translatable("nikostera.itemGroup.teraitems"))
            .entries(((displayContext, entries) -> {
                entries.add(TERA_ORB);
                entries.add(NORMAL_TERA_SHARD);
                entries.add(FIRE_TERA_SHARD);
                entries.add(WATER_TERA_SHARD);
                entries.add(GRASS_TERA_SHARD);
                entries.add(ELECTRIC_TERA_SHARD);
                entries.add(ICE_TERA_SHARD);
                entries.add(FIGHTING_TERA_SHARD);
                entries.add(POISON_TERA_SHARD);
                entries.add(GROUND_TERA_SHARD);
                entries.add(FLYING_TERA_SHARD);
                entries.add(PSYCHIC_TERA_SHARD);
                entries.add(BUG_TERA_SHARD);
                entries.add(ROCK_TERA_SHARD);
                entries.add(GHOST_TERA_SHARD);
                entries.add(DRAGON_TERA_SHARD);
                entries.add(DARK_TERA_SHARD);
                entries.add(FAIRY_TERA_SHARD);
                entries.add(STEEL_TERA_SHARD);
                entries.add(STELLAR_TERA_SHARD);
            }))
            .build();

    public static void registerItemGroup(){
        Identifier test;
        Registry.register(Registries.ITEM_GROUP,test = Identifier.of(MOD_ID, "teraobjects"), TERA_OBJECTS);
    }
}
