package io.github.kawaiiguilds.task;

import io.github.kawaiiguilds.Config;
import io.github.kawaiiguilds.KawaiiGuilds;
import org.bukkit.Bukkit;

import java.sql.SQLException;

public class LoadMySQLTask implements Runnable {

    private KawaiiGuilds kawaiiGuilds;

    public LoadMySQLTask(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void run() {
        /*try {
            if(Config.USER_STORE.equalsIgnoreCase("mysql")) {
                kawaiiGuilds.getMySQL().loadUserData();
            }
            if(Config.GUILD_STORE.equalsIgnoreCase("mysql")) {
               kawaiiGuilds.getMySQL().loadGuildData();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(KawaiiGuilds.getProvidingPlugin(KawaiiGuilds.class));
        }*/
    }
}
