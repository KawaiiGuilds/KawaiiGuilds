package io.github.kawaiiguilds.task;

import io.github.kawaiiguilds.Config;
import io.github.kawaiiguilds.KawaiiGuilds;
import org.bukkit.Bukkit;

import java.sql.SQLException;

public class SaveMySQLTask implements Runnable {

    private KawaiiGuilds kawaiiGuilds;

    public SaveMySQLTask(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void run() {
        try {
            if(Config.USER_STORE.equalsIgnoreCase("mysql")) {
                kawaiiGuilds.getMySQL().saveUserData();
            }
            if(Config.GUILD_STORE.equalsIgnoreCase("mysql")) {
                kawaiiGuilds.getMySQL().saveGuildData();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(KawaiiGuilds.getProvidingPlugin(KawaiiGuilds.class));
        }
    }
}
