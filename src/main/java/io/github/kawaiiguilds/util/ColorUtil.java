package io.github.kawaiiguilds.util;

import org.bukkit.ChatColor;

public final class ColorUtil {

    private ColorUtil(){
    }

    public static String fixColor(String row){
        return ChatColor.translateAlternateColorCodes('&', row);
    }

}
