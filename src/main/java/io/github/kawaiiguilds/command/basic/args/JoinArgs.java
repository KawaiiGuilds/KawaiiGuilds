package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.manager.GuildManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinArgs extends SubCommand {

    private final KawaiiGuilds kawaiiGuilds;

    public JoinArgs(KawaiiGuilds kawaiiGuilds) {
        super(
                "dolacz",
                false,
                "kawaiiguilds.command.join",
                "&a/g &7dolacz &6<tag>");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, String subCommandLabel, String[] args) {
        Player player = (Player) sender;
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
        GuildManager guildManager = kawaiiGuilds.getGuildManager();

        if(args.length != 1){
            player.sendMessage(getHelpMessage(""));
            return;
        }

        String tag = args[0].toUpperCase();

        if(!guildManager.tagExists(tag)) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$TAG_DONT_EXISTS, "{TAG}", tag));
            return;
        }

        if(user.hasGuild()) {
            player.sendMessage(Messages.ERROR$HAS_GUILD);
            return;
        }

        Guild guild = kawaiiGuilds.getGuildManager().getGuildByTag(tag);
        if(!guild.hasInvite(user)) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$DONT_HAVE_INVITE, "{TAG}", tag));
        }
        guild.removeInvite(user);
        user.setGuild(guild);
        guild.addMember(user);
        player.sendMessage(StringUtils.replace(Messages.GUILD$JOINED, "{TAG}", guild.getTag()));
    }

}
