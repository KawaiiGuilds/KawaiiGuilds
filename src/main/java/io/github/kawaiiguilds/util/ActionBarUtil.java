package io.github.kawaiiguilds.util;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ActionBarUtil {

    private ActionBarUtil(){
    }

    public static void sendActionBar(Player p, String message) {
        try {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
        } catch (Exception ex) {
            p.sendMessage(message);
        }
    }
}
