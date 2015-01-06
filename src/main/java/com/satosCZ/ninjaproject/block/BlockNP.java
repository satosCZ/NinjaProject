package com.satosCZ.ninjaproject.block;

import com.satosCZ.ninjaproject.creativetab.CreativeTabNP;
import com.satosCZ.ninjaproject.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

//@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class BlockNP extends Block
{
    public BlockNP(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabNP.NP_TAB);
    }

    public BlockNP()
    {
        this(Material.iron);

    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
