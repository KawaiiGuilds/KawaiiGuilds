package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoArgs extends SubCommand {

    private final KawaiiGuilds kawaiiGuilds;

    public InfoArgs(KawaiiGuilds kawaiiGuilds) {
        super(
                "info",
                false,
                "kawaiiguilds.command.info",
                "&a/g &7info &6<guild>");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, String subCommandLabel, String[] args) {
        Player player = (Player) sender;
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());

    }
}