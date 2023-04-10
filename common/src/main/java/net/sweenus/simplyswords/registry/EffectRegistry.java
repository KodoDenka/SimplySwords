package net.sweenus.simplyswords.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKeys;
import net.sweenus.simplyswords.SimplySwords;
import net.sweenus.simplyswords.effect.*;

public class EffectRegistry {

    public static final DeferredRegister<StatusEffect> EFFECT = DeferredRegister.create(SimplySwords.MOD_ID, RegistryKeys.STATUS_EFFECT);

    public static final RegistrySupplier<StatusEffect> OMEN = EFFECT.register("omen", () ->
            new OmenEffect(StatusEffectCategory.HARMFUL, 1124687));
    public static final RegistrySupplier<StatusEffect> WATCHER = EFFECT.register("watcher", () ->
            new WatcherEffect(StatusEffectCategory.HARMFUL, 1124687));
    public static final RegistrySupplier<StatusEffect> WILDFIRE = EFFECT.register("wildfire", () ->
            new WildfireEffect(StatusEffectCategory.HARMFUL, 1124687));
    public static final RegistrySupplier<StatusEffect> STORM = EFFECT.register("storm", () ->
            new StormEffect(StatusEffectCategory.HARMFUL, 1124687));

    public static final RegistrySupplier<StatusEffect> FREEZE = EFFECT.register("freeze", () ->
            new FreezeEffect(StatusEffectCategory.HARMFUL, 1124687));
    public static final RegistrySupplier<StatusEffect> WARD = EFFECT.register("ward", () ->
            new WardEffect(StatusEffectCategory.BENEFICIAL, 1124687));

}