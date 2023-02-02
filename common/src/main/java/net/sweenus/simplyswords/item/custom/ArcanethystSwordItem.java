package net.sweenus.simplyswords.item.custom;


import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.sweenus.simplyswords.config.SimplySwordsConfig;
import net.sweenus.simplyswords.registry.SoundRegistry;
import net.sweenus.simplyswords.util.AbilityMethods;
import net.sweenus.simplyswords.util.HelperMethods;

import java.util.List;

public class ArcanethystSwordItem extends SwordItem {
    public ArcanethystSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    private static int stepMod = 0;
    int radius = (int) (SimplySwordsConfig.getFloatValue("arcaneassault_radius"));
    int arcaneDamage = (int) (SimplySwordsConfig.getFloatValue("arcaneassault_damage"));
    int arcane_timer_max = (int) (SimplySwordsConfig.getFloatValue("arcaneassault_duration"));
    int skillCooldown = (int) (SimplySwordsConfig.getFloatValue("arcaneassault_cooldown"));
    int chargeChance =  (int) (SimplySwordsConfig.getFloatValue("arcaneassault_chance"));
    int chargeCount;
    int arcane_timer;



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.world.isClient()) {
            HelperMethods.playHitSounds(attacker, target);

            if (attacker.getRandom().nextInt(100) <= chargeChance) {
                if (chargeCount < 3) {
                    chargeCount++;
                    attacker.world.playSoundFromEntity(null, attacker, SoundRegistry.MAGIC_BOW_SHOOT_IMPACT_01.get(), SoundCategory.PLAYERS, 0.5f, 1.2f);
                }
            }
        }

            return super.postHit(stack, target, attacker);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!user.world.isClient()) {

            if (chargeCount > 0) {
                ItemStack itemStack = user.getStackInHand(hand);
                if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1) {
                    return TypedActionResult.fail(itemStack);
                }

                world.playSoundFromEntity(null, user, SoundRegistry.MAGIC_BOW_SHOOT_IMPACT_02.get(), SoundCategory.PLAYERS, 0.4f, 1.2f);
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {

        if (user.getEquippedStack(EquipmentSlot.MAINHAND) == stack && (user instanceof PlayerEntity player)) {

            AbilityMethods.tickAbilityArcaneAssault(stack, world, user, remainingUseTicks, arcane_timer_max, arcaneDamage,
                    skillCooldown, radius, chargeCount);

        }
    }


    @Override
    public int getMaxUseTime(ItemStack stack) {
        return arcane_timer_max;
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient && (user instanceof PlayerEntity player)) {
            player.getItemCooldownManager().set(stack.getItem(), skillCooldown);
            chargeCount = 0;
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (stepMod > 0)
            stepMod --;
        if (stepMod <= 0)
            stepMod = 7;
        HelperMethods.createFootfalls(entity, stack, world, stepMod, ParticleTypes.DRAGON_BREATH, ParticleTypes.DRAGON_BREATH, ParticleTypes.REVERSE_PORTAL, true);

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        //1.19

        tooltip.add(new LiteralText(""));
        tooltip.add(new TranslatableText("item.simplyswords.arcanethystsworditem.tooltip1").formatted(Formatting.GOLD, Formatting.BOLD));
        tooltip.add(new LiteralText(""));
        tooltip.add(new TranslatableText("item.simplyswords.arcanethystsworditem.tooltip2"));
        tooltip.add(new LiteralText(""));
        tooltip.add(new TranslatableText("item.simplyswords.onrightclick").formatted(Formatting.BOLD, Formatting.GREEN));
        tooltip.add(new TranslatableText("item.simplyswords.arcanethystsworditem.tooltip3"));
        tooltip.add(new TranslatableText("item.simplyswords.arcanethystsworditem.tooltip4"));
        tooltip.add(new LiteralText(""));
        tooltip.add(new TranslatableText("item.simplyswords.arcanethystsworditem.tooltip5"));
        tooltip.add(new TranslatableText("item.simplyswords.arcanethystsworditem.tooltip6"));
        tooltip.add(new TranslatableText("item.simplyswords.arcanethystsworditem.tooltip7"));
        tooltip.add(new LiteralText(""));

    }

}
