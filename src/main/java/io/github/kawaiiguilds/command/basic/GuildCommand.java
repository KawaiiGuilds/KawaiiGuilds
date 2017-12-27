package io.github.kawaiiguilds.command.basic;

import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            MessageUtil.sendMessage(sender, Messages.COMMANDLIST);
            return true;
        }
        return true;
    }
}
