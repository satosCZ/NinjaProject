package com.satosCZ.ninjaproject.handler;

import com.satosCZ.ninjaproject.item.ItemWeaponInterface;
import com.satosCZ.ninjaproject.utility.ExtendedReachHelper;
import com.satosCZ.ninjaproject.utility.ExtendedReachItemHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.FOVUpdateEvent;

@SideOnly(Side.CLIENT)
public class ClientEventHandler
{
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e)
    {
        if (!e.player.worldObj.isRemote)
        {
            return;
        }
        if (e.phase == TickEvent.Phase.END)
        {
            if (e.player != null && e.player.swingProgressInt == 1) // Just swung
            {
                ItemStack itemstack = e.player.getCurrentEquippedItem();
                ExtendedReachItemHelper ieri;
                if (itemstack != null)
                {
                    if (itemstack.getItem() instanceof ExtendedReachItemHelper)
                    {
                        ieri = (ExtendedReachItemHelper) itemstack.getItem();
                    } else if (itemstack.getItem() instanceof ItemWeaponInterface && ((ItemWeaponInterface) itemstack.getItem()) instanceof ExtendedReachItemHelper)
                    {
                        ieri = (ExtendedReachItemHelper) ((ItemWeaponInterface) itemstack.getItem());
                    } else
                    {
                        ieri = null;
                    }
                    if (ieri != null)
                    {
                        float reach;
                        reach = ieri.getExtendedReach(e.player.worldObj, e.player, itemstack);
                        MovingObjectPosition mov = ExtendedReachHelper.getMouseOver(0, reach);
                        if (mov != null && mov.entityHit != null && mov.entityHit != e.player && mov.entityHit.hurtResistantTime == 0)
                        {
                            FMLClientHandler.instance().getClient().playerController.attackEntity(e.player, mov.entityHit);
                        }
                    }
                }
            }
        } else if (e.phase == TickEvent.Phase.START && e.player instanceof EntityPlayerSP)
        {
            EntityPlayerSP entity = (EntityPlayerSP) e.player;
        }
    }
}
