package io.github.kawaiiguilds.listener;

import io.github.kawaiiguilds.KawaiiGuilds;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    private final KawaiiGuilds kawaiiGuilds;

    public AsyncPlayerChatListener(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(final AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();


    }
}
