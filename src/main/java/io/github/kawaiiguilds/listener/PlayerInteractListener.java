package io.github.kawaiiguilds.listener;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.Cuboid;
import io.github.kawaiiguilds.basic.User;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    private final KawaiiGuilds kawaiiGuilds;

    public PlayerInteractListener(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @EventHandler
    public void onPlayerInteractEvent(final PlayerInteractEvent event) {
        Player player = event.getPlayer();
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
        Block block = event.getClickedBlock();
        if (block == null) {
            return;
        }
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
            return;
        }
        if (block.getType() == Material.DRAGON_EGG) {
            Cuboid cuboid = kawaiiGuilds.getCuboid();
            if (cuboid != null) {
                event.setCancelled(true);
                //TODO send information of guild
            }
        }
    }
}