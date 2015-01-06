package com.satosCZ.ninjaproject.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.Random;
import java.util.UUID;

public interface ItemWeaponInterface
{
    public boolean onLeftClickEntity(ItemStack itemstack, EntityPlayer player, Entity entity);
    public UUID getUUID();
    public Random getItemRand();
}
