package io.github.kawaiiguilds.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener{

    @EventHandler
    public void onPlayerJoinEvent(final PlayerJoinEvent event){
        Player player = event.getPlayer();
    }
}
