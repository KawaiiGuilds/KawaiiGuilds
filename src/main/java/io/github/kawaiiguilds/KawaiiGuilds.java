package io.github.kawaiiguilds;

import io.github.kawaiiguilds.command.basic.args.CreateArgs;
import io.github.kawaiiguilds.command.executorbase.CommandExecutorBase;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.kawaiiguilds.listener.player.AsyncPlayerChatListener;
import io.github.kawaiiguilds.listener.player.PlayerJoinListener;

import java.io.File;
import java.util.stream.Stream;

public final class KawaiiGuilds extends JavaPlugin{

    @Override
    public void onEnable() {
        Messages.init(new File(this.getDataFolder(), "messages.yml"));
        Config.init(new File(this.getDataFolder(), "config.yml"));

        Stream.of(
                new PlayerJoinListener(), new AsyncPlayerChatListener()
        ).forEach(l -> this.getServer().getPluginManager().registerEvents(l, this));

        CommandExecutorBase cmdBase = new CommandExecutorBase("kawaiiguilds.command.basic");
        cmdBase.addSubCommand(new CreateArgs(this));
        this.getCommand("guild").setExecutor(cmdBase);
    }

    @Override
    public void onDisable(){

    }

}
