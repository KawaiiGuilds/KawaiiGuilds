package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sun.misc.resources.Messages_fr;

public class LeaveArgs extends SubCommand {

    private final KawaiiGuilds kawaiiGuilds;

    public LeaveArgs(KawaiiGuilds kawaiiGuilds) {
        super(
                "opusc",
                false,
                "kawaiiguilds.command.leave",
                "&a/g &7opusc");
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
        player.sendMessage(StringUtils.replace(Messages.GUILD$LEFT, "{TAG}", user.getGuild().getTag()));
        user.setGuild(null);
    }
}