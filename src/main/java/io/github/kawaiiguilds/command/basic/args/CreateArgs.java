package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.Config;
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

public class CreateArgs extends SubCommand {

    private final KawaiiGuilds kawaiiGuilds;

    public CreateArgs(KawaiiGuilds kawaiiGuilds) {
        super("zaloz",
                false,
                "kawaiiguilds.command.create",
                "&a/g &7zaloz &6<tag> <nazwa>");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, String subCommandLabel, String[] args) {
        Player player = (Player) sender;
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
        GuildManager guildManager = kawaiiGuilds.getGuildManager();

        if(user.getGuild() != null) {
            player.sendMessage(Messages.ERROR$HAS_GUILD);
            return;
        }
        String name = args[0];
        String tag = args[1].toUpperCase();

        if(guildManager.tagExists(tag)) {
            player.sendMessage(Messages.ERROR$TAG_EXISTS.replace("{TAG}", tag));
            return;
        }

        if(guildManager.nameExists(name)) {
            player.sendMessage(Messages.ERROR$NAME_EXISTS.replace("{NAME}", name));
            return;
        }

        if(tag.length() != Config.TAGLENGTH) {
            player.sendMessage(Messages.ERROR$TAG_LENGTH);
            return;
        }

        if(name.length() > Config.NAME_MINLENGTH) {
            player.sendMessage(Messages.ERROR$NAME_MAX_LENGTH.replace("{MAXLENGTH}", Integer.toString(Config.NAME_MAXLENGTH)));
            return;
        }
        if(name.length() > Config.NAME_MAXLENGTH) {
            player.sendMessage(Messages.ERROR$NAME_MIN_LENGTH.replace("{MINLENGTH}", Integer.toString(Config.NAME_MINLENGTH)));
            return;
        }

        if (!tag.matches("[a-zA-Z]+")) {
            player.sendMessage(Messages.ERROR$TAG);
            return;
        }

        if (!name.matches("[a-zA-Z]+")) {
            player.sendMessage(Messages.ERROR$NAME);
            return;
        }


    }
}
