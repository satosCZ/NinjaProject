package com.satosCZ.ninjaproject;

import com.satosCZ.ninjaproject.utility.LogHelper;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;

public abstract class PlayerData
{
    public static void initPlayerData(EntityPlayer player)
    {
        String playerName = getPlayerName(player);
    }

    private static String getPlayerName(EntityPlayer player)
    {
        String playerName;
        if (player.getGameProfile() != null)
        {
            playerName = player.getCommandSenderName();
        } else
        {
            playerName = "[unknown]";
        }
        playerName = "Player: " + playerName;
        return playerName;
    }
}
