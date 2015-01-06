package com.satosCZ.ninjaproject.utility;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ExtendedReachItemHelper
{
    public float getExtendedReach(World world, EntityLivingBase entityLivingBase, ItemStack itemStack);
}
