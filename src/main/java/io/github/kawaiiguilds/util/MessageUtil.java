package io.github.kawaiiguilds.util;

import org.bukkit.command.CommandSender;

import java.util.Collection;

public class MessageUtil {

    private MessageUtil() {
    }

    public static boolean sendMsg(CommandSender sender, String message) {
        sender.sendMessage(ColorUtil.fixColor(message));
        return true;
    }

    public static boolean sendMsg(Collection<? extends CommandSender> collection, String message) {
        for (CommandSender sender : collection) sendMsg(sender, message);
        return true;
    }

    public static boolean sendMsg(CommandSender sender, Collection<String> messages) {
        for (String string : messages) sendMsg(sender, string);
        return true;
    }

    public static boolean sendMsg(Collection<? extends CommandSender> collection, Collection<String> messages) {
        for (String string : messages) sendMsg(collection, string);
        return true;
    }
}
