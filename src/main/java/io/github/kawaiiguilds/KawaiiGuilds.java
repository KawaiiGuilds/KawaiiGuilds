package io.github.kawaiiguilds;


import io.github.kawaiiguilds.command.basic.args.*;
import io.github.kawaiiguilds.command.executorbase.CommandExecutorBase;
import io.github.kawaiiguilds.listener.*;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.UserManager;
import io.github.kawaiiguilds.manager.impl.GuildManagerImpl;
import io.github.kawaiiguilds.manager.impl.UserManagerImpl;
import io.github.kawaiiguilds.storage.Storage;
import io.github.kawaiiguilds.storage.StorageImpl;
import io.github.kawaiiguilds.storage.database.Database;
import io.github.kawaiiguilds.storage.database.mysql.MySQL;
import io.github.kawaiiguilds.util.PluginUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public final class KawaiiGuilds extends JavaPlugin {

    private final UserManager userManager = new UserManagerImpl(this);
    private final GuildManager guildManager = new GuildManagerImpl(this);
    private Database mySQL;
    private final Storage storage = new StorageImpl(this);

    @Override
    public void onEnable() {
        Messages.init(new File(this.getDataFolder(), "messages.yml"));
        Config.init(new File(this.getDataFolder(), "config.yml"));

        CommandExecutorBase cmdBase = new CommandExecutorBase("kawaiiguilds.command.basic");
        cmdBase.addSubCommand(new CreateArgs(this));
        cmdBase.addSubCommand(new InviteArgs(this));
        cmdBase.addSubCommand(new JoinArgs(this));
        cmdBase.addSubCommand(new DeleteArgs(this));
        cmdBase.addSubCommand(new InfoArgs(this));
        this.getCommand("kawaiiguilds").setExecutor(cmdBase);

        PluginUtil.registerListeners(this,
                new PlayerJoinListener(this),
                new AsyncPlayerChatListener(this),
                new BlockPlaceListener(this),
                new PlayerInteractListener(this)
        );

        if(Config.USER_STORE.equalsIgnoreCase("mysql") || Config.GUILD_STORE.equalsIgnoreCase("mysql")) {
            this.mySQL = new MySQL(this);
        }
        try {
            this.storage.loadAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        try {
            this.mySQL.disconnect();
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

    public Database getMySQL() {
        return this.mySQL;
    }

}
