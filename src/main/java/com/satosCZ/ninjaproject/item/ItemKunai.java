package com.satosCZ.ninjaproject.item;

import com.satosCZ.ninjaproject.creativetab.CreativeTabNP;
import com.satosCZ.ninjaproject.entity.EntityKunai;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.MathHelper;

public class ItemKunai extends ItemNP
{
    public ItemKunai()
    {
        super();
        this.setUnlocalizedName("kunai");
        this.
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (this.itemRand.nextFloat() * 0.2F + 0.9F));
        if (!world.isRemote)
        {
            EntityKunai entity = new EntityKunai(world, entityplayer, itemstack);
            entity.setKnockbackStrength(EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, itemstack));
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, itemstack) > 0)
            {
                entity.setFire(100);
            }
            world.spawnEntityInWorld(entity);
        }
        if (!entityplayer.capabilities.isCreativeMode)
        {
            itemstack = itemstack.copy();
            itemstack.stackSize = 0;
        }

        return itemstack;
    }
}
