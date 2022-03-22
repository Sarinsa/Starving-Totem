package com.sarinsa.starvingtotem.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class AbstractTotemItem extends Item {

    public AbstractTotemItem() {
        super(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_COMBAT).rarity(Rarity.UNCOMMON));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand p_77659_3_) {
        ItemStack itemstack = player.getItemInHand(p_77659_3_);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world.isClientSide) {
            SnowballEntity snowballentity = new SnowballEntity(world, player);
            snowballentity.setItem(itemstack);
            snowballentity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(snowballentity);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            itemstack.shrink(1);
        }
        return ActionResult.sidedSuccess(itemstack, world.isClientSide());
    }
}

