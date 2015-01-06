package com.satosCZ.ninjaproject.proxy;

import com.satosCZ.ninjaproject.entity.EntityKunai;
import com.satosCZ.ninjaproject.handler.ClientEventHandler;
import com.satosCZ.ninjaproject.render.RenderKunai;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.MinecraftForge;

public class ServerProxy extends CommonProxy
{
    @Override
    @SideOnly(Side.CLIENT)
    public void registerEventHandlers()
    {
        super.registerEventHandlers();
        ClientEventHandler eventHandler = new ClientEventHandler();
        FMLCommonHandler.instance().bus().register(eventHandler);
        MinecraftForge.EVENT_BUS.register(eventHandler);
    }

    public void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityKunai.class, new RenderKunai());
    }

}
