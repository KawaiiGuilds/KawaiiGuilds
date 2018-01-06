package io.github.kawaiiguilds.util;

import io.github.kawaiiguilds.KawaiiGuilds;
import org.bukkit.event.Listener;

public class PluginUtil {

    private PluginUtil() {
    }

    public static void registerListeners(KawaiiGuilds kawaiiGuilds, Listener... listeners) {
        for (Listener listener : listeners) {
            kawaiiGuilds.getServer().getPluginManager().registerEvents(listener, kawaiiGuilds);
        }
    }


}
