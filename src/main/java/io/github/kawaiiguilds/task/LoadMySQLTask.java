package io.github.kawaiiguilds.task;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.storage.database.mysql.MySQL;
import org.bukkit.scheduler.BukkitRunnable;

public class LoadMySQLTask extends BukkitRunnable {

    private KawaiiGuilds kawaiiGuilds;

    public LoadMySQLTask(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void run() {
        MySQL.loadData();
    }
}
