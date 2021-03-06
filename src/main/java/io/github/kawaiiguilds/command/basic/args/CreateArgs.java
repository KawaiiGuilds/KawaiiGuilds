package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.Config;
import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.basic.impl.GuildImpl;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.util.GuildCreateUtil;
import io.github.kawaiiguilds.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
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

        if(args.length != 2){
            sender.sendMessage(getHelpMessage(""));
            return;
        }

        if(user.getGuild() != null) {
            sender.sendMessage(Messages.ERROR$HAS_GUILD);
            return;
        }

        String tag = args[0].toUpperCase();
        String name = args[1];
        GuildManager guildManager = kawaiiGuilds.getGuildManager();

        if(guildManager.tagExists(tag)) {
            sender.sendMessage(StringUtils.replace(Messages.ERROR$TAG_EXISTS,"{TAG}", tag));
            return;
        }

        if(tag.length() < Config.TAG$MIN_LENGTH) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$TAG_MIN_LENGTH,"{MINLENGTH}", Integer.toString(Config.TAG$MIN_LENGTH)));
            return;
        }

        if(tag.length() > Config.TAG$MAX_LENGTH) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$TAG_MAX_LENGTH,"{MAXLENGTH}", Integer.toString(Config.TAG$MAX_LENGTH)));
            return;
        }

        if(guildManager.nameExists(name)) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$NAME_EXISTS,"{NAME}", name));
            return;
        }

        if(name.length() < Config.NAME$MIN_LENGTH) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$NAME_MIN_LENGTH,"{MINLENGTH}", Integer.toString(Config.NAME$MIN_LENGTH)));
            return;
        }

        if(name.length() > Config.NAME$MAX_LENGTH) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$NAME_MAX_LENGTH,"{MAXLENGTH}", Integer.toString(Config.NAME$MAX_LENGTH)));
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

        Guild guild = guildManager.createGuild(tag, name, user);
        if (Config.GUILD$CREATED_BROADCAST) {
            MessageUtil.sendBroadcastMessage(Messages.GUILD$CREATED_BROADCAST.replace("{PLAYER}", player.getName()).replace("{TAG}", guild.getTag()).replace("{NAME}", guild.getName()));
        } else {
            player.sendMessage(Messages.GUILD$CREATED.replace("{TAG}", guild.getTag()).replace("{NAME}", guild.getName()));
        }
    }
}
