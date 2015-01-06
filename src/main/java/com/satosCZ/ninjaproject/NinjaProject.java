package com.satosCZ.ninjaproject;

import com.satosCZ.ninjaproject.handler.ConfigurationHandler;
import com.satosCZ.ninjaproject.init.ModBlocks;
import com.satosCZ.ninjaproject.init.ModItems;
import com.satosCZ.ninjaproject.init.Recipes;
import com.satosCZ.ninjaproject.proxy.ClientProxy;
import com.satosCZ.ninjaproject.proxy.CommonProxy;
import com.satosCZ.ninjaproject.proxy.IProxy;
import com.satosCZ.ninjaproject.reference.Reference;
import com.satosCZ.ninjaproject.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class NinjaProject
{
    @Mod.Instance(Reference.MOD_ID)
    public static NinjaProject instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    public static CommonProxy cProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
   {
       ConfigurationHandler.init(event.getSuggestedConfigurationFile());
       FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

       ModItems.Init();

       ModBlocks.Init();

       LogHelper.info("Pre Initialization Complete!");
   }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        Recipes.init();
        proxy.registerRenderers();
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}
