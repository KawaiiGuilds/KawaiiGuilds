package io.github.kawaiiguilds.command.basic.args;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.command.executorbase.SubCommand;
import io.github.kawaiiguilds.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CreateArgs extends SubCommand{

    private final KawaiiGuilds kawaiiGuilds;

    public CreateArgs(KawaiiGuilds kawaiiGuilds) {
        super("create",
                false,
                "kawaiiguilds.command.create",
                "");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void runCommand(CommandSender sender, Command baseCommand, String baseCommandLabel, String subCommandLabel, String[] subCommandArgs) {
        MessageUtil.sendMessage(sender, "&aZalozyles gildie");
    }
}
