package io.github.kawaiiguilds.task;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.storage.database.mysql.MySQL;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;

public class LoadMySQLTask implements Runnable {

    private KawaiiGuilds kawaiiGuilds;

    public LoadMySQLTask(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void run() {
        try {
            kawaiiGuilds.getMySQL().loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
