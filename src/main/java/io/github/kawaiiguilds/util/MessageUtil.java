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

    public static void sendMessage(Collection<? extends CommandSender> collection, String message) {
        for (CommandSender sender : collection) sendMessage(sender, message);
    }

    public static void sendMessage(CommandSender sender, Collection<String> messages) {
        for (String string : messages) sendMessage(sender, string);
    }

    public static boolean sendMessage(Collection<? extends CommandSender> collection, Collection<String> messages) {
        for (String string : messages) sendMessage(collection, string);
        return true;
    }

    public static void sendBroadcastMessage(String message) {
        Bukkit.getOnlinePlayers().forEach((p) -> sendMessage(p, message));
    }
}
