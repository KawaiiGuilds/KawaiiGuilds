package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
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
    }
}