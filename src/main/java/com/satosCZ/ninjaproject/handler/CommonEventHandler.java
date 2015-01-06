package com.satosCZ.ninjaproject.handler;

import com.satosCZ.ninjaproject.PlayerData;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

public class CommonEventHandler
{
    @SubscribeEvent
    public void onEntityConstructed(EntityEvent.EntityConstructing event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            PlayerData.initPlayerData((EntityPlayer) event.entity);
        }
    }
}
