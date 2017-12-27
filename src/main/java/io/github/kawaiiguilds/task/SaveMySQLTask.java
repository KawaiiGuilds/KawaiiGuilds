package io.github.kawaiiguilds.task;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.storage.database.mysql.MySQL;
import org.bukkit.scheduler.BukkitRunnable;

public class SaveMySQLTask extends BukkitRunnable {

    private KawaiiGuilds kawaiiGuilds;

    public SaveMySQLTask(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void run() {
        MySQL.saveData();
    }
}
