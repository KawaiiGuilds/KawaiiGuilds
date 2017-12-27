package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.data.User;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.UserManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateArgs extends SubCommand{

    private final KawaiiGuilds kawaiiGuilds;

    public CreateArgs(KawaiiGuilds kawaiiGuilds) {
        super("zaloz",
                false,
                "kawaiiguilds.command.create",
                "&a/g &7zaloz &6<tag> <nazwa>");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, String subCommandLabel, String[] args){
        Player player = (Player) sender;
        User user = UserManager.getUser(player.getUniqueId());
        Guild guild = user.getGuild();

        if(guild != null){
            player.sendMessage(Messages.HASGUILD);
            return;
        }
        String name = args[0];
        String tag = args[1].toUpperCase();

        if(GuildManager.tagExists(tag)){
            player.sendMessage(Messages.TAGEXISTS);
            return;
        }
        if(GuildManager.nameExists(name)){
            player.sendMessage(Messages.NAMEEXISTS);
            return;
        }

    }
}
