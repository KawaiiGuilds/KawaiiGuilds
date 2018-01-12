package io.github.kawaiiguilds.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.Collection;

public class MessageUtil {

    private MessageUtil() {
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ColorUtil.fixColor(message));
    }

    public static void sendMessage(CommandSender sender, Collection<String> messages) {
        for (String string : messages) sendMessage(sender, string);
    }

    public static void sendBroadcastMessage(String message) {
        Bukkit.getOnlinePlayers().forEach((p) -> sendMessage(p, message));
    }
}
