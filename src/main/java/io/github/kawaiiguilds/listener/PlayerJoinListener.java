package io.github.kawaiiguilds.listener;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

public class PlayerJoinListener implements Listener {

    private final KawaiiGuilds kawaiiGuilds;

    public PlayerJoinListener(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @EventHandler
    public void onPlayerJoinEvent(final PlayerJoinEvent event) {
        Player player = event.getPlayer();
        kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
    }
}
