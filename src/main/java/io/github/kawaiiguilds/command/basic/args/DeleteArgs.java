package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteArgs extends SubCommand {

    private final KawaiiGuilds kawaiiGuilds;

    public DeleteArgs(KawaiiGuilds kawaiiGuilds) {
        super(
                "usun",
                false,
                "kawaiiguilds.command.delete",
                "&a/g &7usun");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, String subCommandLabel, String[] args) {
        Player player = (Player) sender;
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());

        if(args.length != 0){
            player.sendMessage(getHelpMessage(""));
            return;
        }

        if(!user.hasGuild()) {
            player.sendMessage(Messages.ERROR$DONT_HAVE_GUILD);
            return;
        }

        user.setGuild(null);
        MessageUtil.sendMessage(player, "&cNie jestes juz w gildii");

    }
}