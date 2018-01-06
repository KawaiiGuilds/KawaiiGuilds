package io.github.kawaiiguilds.listener;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.Guild;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    private final KawaiiGuilds kawaiiGuilds;

    public BlockPlaceListener(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @EventHandler
    public void onBlockPlaceEvent(final BlockPlaceEvent event) {
        Player player = event.getPlayer();



    }
}
