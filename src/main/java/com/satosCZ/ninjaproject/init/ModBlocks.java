package com.satosCZ.ninjaproject.init;

import com.satosCZ.ninjaproject.block.BlockChakraSteel;
import com.satosCZ.ninjaproject.block.BlockNP;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
    public static final BlockNP chakraSteelBlock = new BlockChakraSteel();

    public static void Init()
    {
        GameRegistry.registerBlock(chakraSteelBlock, "chakraSteelBlock");
    }
}
