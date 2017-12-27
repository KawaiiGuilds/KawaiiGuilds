package io.github.kawaiiguilds.listener;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.data.MessageType;
import io.github.kawaiiguilds.manager.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class PlayerJoinListener implements Listener {

    private final KawaiiGuilds kawaiiGuilds;

    public PlayerJoinListener(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @EventHandler
    public void onPlayerJoinEvent(final PlayerJoinEvent event) {
        Player player = event.getPlayer();

        kawaiiGuilds.getUserManager().createUser(player.getUniqueId(),
                player.getName(),
                MessageType.CHAT);
    }
}
