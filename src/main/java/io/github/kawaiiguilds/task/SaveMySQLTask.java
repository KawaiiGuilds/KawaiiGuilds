package io.github.kawaiiguilds.task;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.storage.database.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;

public class SaveMySQLTask implements Runnable {

    private KawaiiGuilds kawaiiGuilds;

    public SaveMySQLTask(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void run() {
        try {
            kawaiiGuilds.getMySQL().saveData();
        } catch (SQLException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(KawaiiGuilds.getProvidingPlugin(KawaiiGuilds.class));
        }
    }
}
