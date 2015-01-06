package com.satosCZ.ninjaproject.creativetab;

import com.satosCZ.ninjaproject.init.ModItems;
import com.satosCZ.ninjaproject.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabNP
{
    public static final CreativeTabs NP_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem() {
            return ModItems.kunai;
        }
    };
}
