package io.github.kawaiiguilds.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener{


    @EventHandler
    public void onAsyncPlayerChatEvent(final AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

    }
}
