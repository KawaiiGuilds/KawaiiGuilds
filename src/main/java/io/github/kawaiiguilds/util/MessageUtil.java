package io.github.kawaiiguilds.util;

import org.bukkit.command.CommandSender;

import java.util.Collection;
import java.util.List;

public class MessageUtil {

    private MessageUtil( ){
    }

    public static void sendMessage(Collection<? extends CommandSender col, List<String> message) {
        sendMessage(col, message);
    }

    public static void sendMessage(Collection<? extends CommandSender col, String message) {
        for (CommandSender commandSender : col) {
            sendMessage(col, message);
        }
    }

    public static void sendMessage(CommandSender sender, List<String> message) {
        message.forEach(string -> sendMessage(sender, string));
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ColorUtil.fixColor(message));
    }

}
