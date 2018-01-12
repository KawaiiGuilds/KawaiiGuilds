package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InviteArgs extends SubCommand {

    private final KawaiiGuilds kawaiiGuilds;

    public InviteArgs(KawaiiGuilds kawaiiGuilds) {
        super(
                "zapros",
                false,
                "kawaiiguilds.command.invite",
                "&a/g &7zapros &6<gracz>");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, String subCommandLabel, String[] args) {
        Player player = (Player) sender;
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());

        if(args.length != 1){
            player.sendMessage(getHelpMessage(""));
            return;
        }

        if(!user.hasGuild()) {
            player.sendMessage(Messages.ERROR$DONT_HAVE_GUILD);
            return;
        }

        User dusty = kawaiiGuilds.getUserManager().getUser(args[0]);
        if(dusty == null) {
            player.sendMessage(Messages.ERROR$NO_PLAYER);
            return;
        }

        if(dusty.hasGuild()) {
            player.sendMessage(StringUtils.replace(Messages.ERROR$PLAYER_HAVE_GUILD, "{PLAYER}", dusty.getName()));
            return;
        }


        Guild guild = user.getGuild();

        guild.addInvite(dusty);
        user.sendMessage(StringUtils.replace(Messages.GUILD$INVITE$SEND$TO$LEADER, "{PLAYER}", dusty.getName()));
        dusty.sendMessage(StringUtils.replace(Messages.GUILD$INVITE$SEND$TO$USER, "{TAG}", guild.getTag()));

    }


}


