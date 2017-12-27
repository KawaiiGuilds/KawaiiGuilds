package io.github.kawaiiguilds;

import io.github.kawaiiguilds.command.basic.args.CreateArgs;
import io.github.kawaiiguilds.command.executorbase.CommandExecutorBase;
import io.github.kawaiiguilds.listener.player.AsyncPlayerChatListener;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.UserManager;
import io.github.kawaiiguilds.manager.impl.GuildManagerImpl;
import io.github.kawaiiguilds.manager.impl.UserManagerImpl;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.kawaiiguilds.listener.PlayerJoinListener;

import java.io.File;

public final class KawaiiGuilds extends JavaPlugin {

    private final UserManager userManager = new UserManagerImpl();
    private final GuildManager guildManager = new GuildManagerImpl();

    @Override
    public void onEnable() {
        Messages.init(new File(this.getDataFolder(), "messages.yml"));
        Config.init(new File(this.getDataFolder(), "config.yml"));

        registerListeners(new PlayerJoinListener(), new AsyncPlayerChatListener());

        CommandExecutorBase cmdBase = new CommandExecutorBase("kawaiiguilds.command.basic");
        cmdBase.addSubCommand(new CreateArgs(this));
        this.getCommand("kawaiiguilds").setExecutor(cmdBase);
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners(Listener... listeners) {
        final PluginManager pluginManager = this.getServer().getPluginManager();
        for (Listener listener : listeners) {
            pluginManager.registerEvents(listener, this);
        }
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public GuildManager getGuildManager() {
        return this.guildManager;
    }
}
