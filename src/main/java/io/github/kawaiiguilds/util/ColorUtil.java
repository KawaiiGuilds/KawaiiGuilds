package io.github.kawaiiguilds.util;

import org.bukkit.ChatColor;

import java.util.List;

public final class ColorUtil {

    private ColorUtil() {
    }

    public static String fixColor(String row) {
        return ChatColor.translateAlternateColorCodes('&', row);
    }

    public static String[] fixColor(String[] s) {
        for (int i = 0; i < s.length; i++) s[i] = fixColor(s[i]);
        return s;
    }

    public static List<String> fixColor(List<String> s) {
        for (int i = 0; i < s.size(); i++) {
            String string = s.get(i);
            s.set(i, fixColor(string));
        }
        return s;

    }
}
