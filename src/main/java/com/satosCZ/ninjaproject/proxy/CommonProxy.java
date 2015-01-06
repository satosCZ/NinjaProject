package com.satosCZ.ninjaproject.proxy;

import com.satosCZ.ninjaproject.handler.CommonEventHandler;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy
{
    public void registerEventHandlers()
    {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
    }
}
