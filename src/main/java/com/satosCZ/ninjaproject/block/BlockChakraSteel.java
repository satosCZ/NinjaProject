package com.satosCZ.ninjaproject.block;

import com.satosCZ.ninjaproject.creativetab.CreativeTabNP;

public class BlockChakraSteel extends BlockNP
{
    public BlockChakraSteel()
    {
        super();
        this.setBlockName("chakraSteelBlock");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeMetal);
        this.setLightLevel(10.0F);
        this.setCreativeTab(CreativeTabNP.NP_TAB);
    }

}
