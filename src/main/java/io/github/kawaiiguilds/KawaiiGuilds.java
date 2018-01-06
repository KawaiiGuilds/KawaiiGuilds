package io.github.kawaiiguilds;

import io.github.kawaiiguilds.basic.Cuboid;
import io.github.kawaiiguilds.basic.impl.CuboidImpl;
import io.github.kawaiiguilds.command.basic.args.CreateArgs;
import io.github.kawaiiguilds.command.basic.args.DeleteArgs;
import io.github.kawaiiguilds.command.basic.args.InviteArgs;
import io.github.kawaiiguilds.command.executorbase.CommandExecutorBase;
import io.github.kawaiiguilds.listener.AsyncPlayerChatListener;
import io.github.kawaiiguilds.listener.BlockPlaceListener;
import io.github.kawaiiguilds.listener.PlayerInteractListener;
import io.github.kawaiiguilds.listener.PlayerJoinListener;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.UserManager;
import io.github.kawaiiguilds.manager.impl.GuildManagerImpl;
import io.github.kawaiiguilds.manager.impl.UserManagerImpl;
import io.github.kawaiiguilds.storage.Storage;
import io.github.kawaiiguilds.storage.StorageImpl;
import io.github.kawaiiguilds.storage.database.Database;
import io.github.kawaiiguilds.storage.database.mysql.MySQL;
import io.github.kawaiiguilds.task.LoadMySQLTask;
import io.github.kawaiiguilds.task.SaveMySQLTask;
import io.github.kawaiiguilds.util.PluginUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class KawaiiGuilds extends JavaPlugin {

    private final UserManager userManager = new UserManagerImpl();
    private final GuildManager guildManager = new GuildManagerImpl();
    private final Cuboid cuboid = new CuboidImpl();
    private Database mySQL;
    private final Storage storage = new StorageImpl(this);

    @Override
    public void onEnable() {
        Messages.init(new File(this.getDataFolder(), "messages.yml"));
        Config.init(new File(this.getDataFolder(), "config.yml"));

        CommandExecutorBase cmdBase = new CommandExecutorBase("kawaiiguilds.command.basic");
        cmdBase.addSubCommand(new CreateArgs(this));
        cmdBase.addSubCommand(new InviteArgs(this));
        this.getCommand("kawaiiguilds").setExecutor(cmdBase);

        PluginUtil.registerListeners(this,
                new PlayerJoinListener(this),
                new AsyncPlayerChatListener(),
                new BlockPlaceListener(this),
                new PlayerInteractListener(this)
        );

        if(Config.USER_STORE.equalsIgnoreCase("mysql") || Config.GUILD_STORE.equalsIgnoreCase("mysql")) {
            this.mySQL = new MySQL(this);
            //Bukkit.getScheduler().runTaskTimerAsynchronously(this, new LoadMySQLTask(this), 100L, 100L);
            //Bukkit.getScheduler().runTaskTimerAsynchronously(this, new SaveMySQLTask(this), 100L, 100L);
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
            storage.saveAll();
        } catch (IOException exception) {
            exception.printStackTrace();
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

    public Storage getStorage() {
        return this.storage;
    }

    public Cuboid getCuboid() {
        return cuboid;
    }
}
