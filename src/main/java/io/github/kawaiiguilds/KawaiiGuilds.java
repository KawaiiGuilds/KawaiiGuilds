package io.github.kawaiiguilds;

import io.github.kawaiiguilds.command.basic.args.CreateArgs;
import io.github.kawaiiguilds.command.executorbase.CommandExecutorBase;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.UserManager;
import io.github.kawaiiguilds.manager.impl.GuildManagerImpl;
import io.github.kawaiiguilds.manager.impl.UserManagerImpl;
import io.github.kawaiiguilds.storage.database.Database;
import io.github.kawaiiguilds.storage.database.mysql.MySQL;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.kawaiiguilds.listener.PlayerJoinListener;

import java.io.File;
import java.sql.SQLException;

public final class KawaiiGuilds extends JavaPlugin {

    private final UserManager userManager = new UserManagerImpl();
    private final GuildManager guildManager = new GuildManagerImpl();
    private Database mySQL;

    @Override
    public void onEnable() {
        Messages.init(new File(this.getDataFolder(), "messages.yml"));
        Config.init(new File(this.getDataFolder(), "config.yml"));
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

        CommandExecutorBase cmdBase = new CommandExecutorBase("kawaiiguilds.command.basic");
        cmdBase.addSubCommand(new CreateArgs(this));
        this.getCommand("kawaiiguilds").setExecutor(cmdBase);
        this.mySQL = new MySQL(this);
    }

    @Override
    public void onDisable() {
        try {
            this.mySQL.saveData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public GuildManager getGuildManager() {
        return this.guildManager;
    }
}
