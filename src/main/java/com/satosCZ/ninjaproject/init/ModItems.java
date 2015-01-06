package com.satosCZ.ninjaproject.init;

import com.satosCZ.ninjaproject.item.ItemChakraIngot;
import com.satosCZ.ninjaproject.item.ItemKunai;
import com.satosCZ.ninjaproject.item.ItemNP;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final ItemNP kunai = new ItemKunai();
    public static final ItemNP chakraIngot = new ItemChakraIngot();

    public static void Init()
    {
        GameRegistry.registerItem(kunai, "Kunai");
        GameRegistry.registerItem(chakraIngot, "chakraIngot");
    }
}
