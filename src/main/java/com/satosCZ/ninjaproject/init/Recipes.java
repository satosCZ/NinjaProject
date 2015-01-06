package com.satosCZ.ninjaproject.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
    public static void init()
    {
        //Shaped recipes
        //GameRegistry.addShapedRecipe(new ItemStack(ModItems.kunai), " x ", " l ", " s ", 'x', new ItemStack(ModItems.chakraIngot), 'l', new ItemStack(Items.leather), 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.chakraSteelBlock), "iii", "iii", "iii", 'i', new ItemStack(ModItems.chakraIngot));

        //Shaped Ore recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.kunai), " x ", " l ", " s ", 'x', new ItemStack(ModItems.chakraIngot), 'l', new ItemStack(Items.leather), 's', "stickWood"));

        //Shaped recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chakraIngot, 9), new ItemStack(ModBlocks.chakraSteelBlock));
    }
}
