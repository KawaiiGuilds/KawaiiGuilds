package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.Config;
import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.basic.impl.GuildImpl;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateArgs extends SubCommand {

    private final KawaiiGuilds kawaiiGuilds;

    public CreateArgs(KawaiiGuilds kawaiiGuilds) {
        super(
                "zaloz",
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

        if(args.length != 2){
            player.sendMessage(getHelpMessage(""));
            return;
        }

        if(!user.hasGuild()) {
            player.sendMessage(Messages.ERROR$HAS_GUILD);
            return;
        }

        String tag = args[0].toUpperCase();
        String name = args[1];

        if(guildManager.tagExists(tag)) {
            player.sendMessage(Messages.ERROR$TAG_EXISTS.replace("{TAG}", tag));
            return;
        }

        if(guildManager.nameExists(name)) {
            player.sendMessage(Messages.ERROR$NAME_EXISTS.replace("{NAME}", name));
            return;
        }

        if(tag.length() < Config.TAG$MIN_LENGTH) {
            player.sendMessage(Messages.ERROR$TAG_MIN_LENGTH.replace("{MINLENGTH}", Integer.toString(Config.TAG$MIN_LENGTH)));
            return;
        }

        if(tag.length() > Config.TAG$MAX_LENGTH) {
            player.sendMessage(Messages.ERROR$TAG_MAX_LENGTH.replace("{MAXLENGTH}", Integer.toString(Config.TAG$MAX_LENGTH)));
            return;
        }

        if(name.length() < Config.NAME$MIN_LENGTH) {
            player.sendMessage(Messages.ERROR$NAME_MAX_LENGTH.replace("{MAXLENGTH}", Integer.toString(Config.NAME$MAX_LENGTH)));
            return;
        }
        if(name.length() > Config.NAME$MAX_LENGTH) {
            player.sendMessage(Messages.ERROR$NAME_MIN_LENGTH.replace("{MINLENGTH}", Integer.toString(Config.NAME$MIN_LENGTH)));
            return;

        }
        if (!tag.matches(Config.REGEX)) {
            player.sendMessage(Messages.ERROR$TAG);
            return;
        }

        if (!name.matches(Config.REGEX)) {
            player.sendMessage(Messages.ERROR$NAME);
            return;
        }

        Guild guild = new GuildImpl(tag, name, user, player.getLocation());
        kawaiiGuilds.getGuildManager().createGuild(guild, player.getLocation());
        user.setGuild(guild);

        if (Config.GUILD$CREATED_BROADCAST) {
            MessageUtil.sendBroadcastMessage(Messages.GUILD$CREATED_BROADCAST.replace("{PLAYER}", player.getName()).replace("{TAG}", guild.getTag()).replace("{NAME}", guild.getName()));
        } else {
            player.sendMessage(Messages.GUILD$CREATED.replace("{TAG}", guild.getTag()).replace("{NAME}", guild.getName()));
        }

    }
}
