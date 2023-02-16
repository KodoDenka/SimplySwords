package net.sweenus.simplyswords.util;

import dev.architectury.event.events.common.LootEvent;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.sweenus.simplyswords.config.SimplySwordsConfig;
import net.sweenus.simplyswords.registry.ItemsRegistry;

public class ModLootTableModifiers {

    public static void init() {


        //STANDARD
        LootEvent.MODIFY_LOOT_TABLE.register(((lootTables, id, context, builtin) -> {
            if (SimplySwordsConfig.getBooleanValue("add_weapons_to_loot_tables") && id.getPath().contains("chests")) {
                if (!SimplySwordsConfig.getBooleanValue("loot_can_be_found_in_villages") && id.getPath().contains("village")) {
                    //Do nothing
                }
                else {
                    LootPool.Builder pool = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(SimplySwordsConfig.getGeneralSettings("standard_loot_table_weight"))) // 1 = 100% of the time
                            .apply(EnchantRandomlyLootFunction.builder())
                            .with(ItemEntry.builder(ItemsRegistry.IRON_LONGSWORD.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_TWINBLADE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_RAPIER.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_CUTLASS.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_KATANA.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_GLAIVE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_WARGLAIVE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_SPEAR.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_SAI.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_CLAYMORE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_CHAKRAM.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_GREATAXE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_GREATHAMMER.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_SCYTHE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.IRON_HALBERD.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_LONGSWORD.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_TWINBLADE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_RAPIER.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_CUTLASS.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_KATANA.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_GLAIVE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_WARGLAIVE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_SPEAR.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_SAI.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_CLAYMORE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_GREATHAMMER.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_CHAKRAM.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_GREATAXE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_SCYTHE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.GOLD_HALBERD.get()));

                    context.addPool(pool);
                }
            }
        }));

        //RARE
        LootEvent.MODIFY_LOOT_TABLE.register(((lootTables, id, context, builtin) -> {
            if (SimplySwordsConfig.getBooleanValue("add_weapons_to_loot_tables") && id.getPath().contains("chests")) {
                if (!SimplySwordsConfig.getBooleanValue("loot_can_be_found_in_villages") && id.getPath().contains("village")) {
                    //Do nothing
                }
                else {
                    LootPool.Builder pool = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(SimplySwordsConfig.getGeneralSettings("rare_loot_table_weight"))) // 1 = 100% of the time
                            .apply(EnchantRandomlyLootFunction.builder())
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_LONGSWORD.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_TWINBLADE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_RAPIER.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_CUTLASS.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_KATANA.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_SPEAR.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_GLAIVE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_WARGLAIVE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_SAI.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_CLAYMORE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_GREATHAMMER.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_CHAKRAM.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_GREATAXE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_SCYTHE.get()))
                            .with(ItemEntry.builder(ItemsRegistry.DIAMOND_HALBERD.get()));

                    context.addPool(pool);
                }
            }
        }));
        //RARE 2
        LootEvent.MODIFY_LOOT_TABLE.register(((lootTables, id, context, builtin) -> {
            if (SimplySwordsConfig.getBooleanValue("add_weapons_to_loot_tables") && id.getPath().contains("chests")) {
                if (!SimplySwordsConfig.getBooleanValue("loot_can_be_found_in_villages") && id.getPath().contains("village")) {
                    //Do nothing
                }
                else {
                    LootPool.Builder pool = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(SimplySwordsConfig.getGeneralSettings("rare_loot_table_weight"))) // 1 = 100% of the time
                            .with(ItemEntry.builder(ItemsRegistry.RUNIC_TABLET.get()));
                    context.addPool(pool);
                }
            }
        }));

        //UNIQUE
        // Check each loot table against the listed namespaces in the loot_config.json, if there's a match modify the
        // table according to the config. Otherwise, use the loot global loot modifiers set in the general_config.json
        LootEvent.MODIFY_LOOT_TABLE.register(((lootTables, id, context, builtin) -> {
            if (SimplySwordsConfig.getBooleanValue("add_weapons_to_loot_tables")) {
                if (SimplySwordsConfig.getLootList(id.toString())) {
                    float lootChance = SimplySwordsConfig.getLootModifiers(id.toString());
                    if (lootChance > 0.0) { // If chance is set to 0 treat as a blacklist and don't inject the loot at all
                        LootPool.Builder pool = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(lootChance)) // 1 = 100% of the time
                                .with(ItemEntry.builder(ItemsRegistry.WATCHER_CLAYMORE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.TOXIC_LONGSWORD.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SWORD_ON_A_STICK.get()))
                                .with(ItemEntry.builder(ItemsRegistry.BRAMBLETHORN.get()))
                                .with(ItemEntry.builder(ItemsRegistry.STORMS_EDGE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.STORMBRINGER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.MJOLNIR.get()))
                                .with(ItemEntry.builder(ItemsRegistry.EMBERBLADE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.HEARTHFLAME.get()))
                                .with(ItemEntry.builder(ItemsRegistry.TWISTED_BLADE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULRENDER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULPYRE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULKEEPER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULSTEALER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.FROSTFALL.get()))
                                .with(ItemEntry.builder(ItemsRegistry.MOLTEN_EDGE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.LIVYATAN.get()))
                                .with(ItemEntry.builder(ItemsRegistry.ICEWHISPER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.ARCANETHYST.get()))
                                .with(ItemEntry.builder(ItemsRegistry.THUNDERBRAND.get()))
                                .with(ItemEntry.builder(ItemsRegistry.BRIMSTONE_CLAYMORE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SLUMBERING_LICHBLADE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SHADOWSTING.get()));

                        context.addPool(pool);
                    }
                }
                else {
                    if (id.getPath().contains("chests")) {
                        LootPool.Builder pool = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(SimplySwordsConfig.getGeneralSettings("unique_loot_table_weight"))) // 1 = 100% of the time
                                .with(ItemEntry.builder(ItemsRegistry.WATCHER_CLAYMORE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.TOXIC_LONGSWORD.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SWORD_ON_A_STICK.get()))
                                .with(ItemEntry.builder(ItemsRegistry.BRAMBLETHORN.get()))
                                .with(ItemEntry.builder(ItemsRegistry.STORMS_EDGE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.STORMBRINGER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.MJOLNIR.get()))
                                .with(ItemEntry.builder(ItemsRegistry.EMBERBLADE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.HEARTHFLAME.get()))
                                .with(ItemEntry.builder(ItemsRegistry.TWISTED_BLADE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULRENDER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULPYRE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULKEEPER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SOULSTEALER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.FROSTFALL.get()))
                                .with(ItemEntry.builder(ItemsRegistry.MOLTEN_EDGE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.LIVYATAN.get()))
                                .with(ItemEntry.builder(ItemsRegistry.ICEWHISPER.get()))
                                .with(ItemEntry.builder(ItemsRegistry.ARCANETHYST.get()))
                                .with(ItemEntry.builder(ItemsRegistry.THUNDERBRAND.get()))
                                .with(ItemEntry.builder(ItemsRegistry.BRIMSTONE_CLAYMORE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SLUMBERING_LICHBLADE.get()))
                                .with(ItemEntry.builder(ItemsRegistry.SHADOWSTING.get()));

                        context.addPool(pool);
                    }
                }
            }
        }));

    }
}