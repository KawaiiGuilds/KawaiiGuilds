package io.github.kawaiiguilds.listener;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.util.MessageUtil;
import org.bukkit.Location;
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
        Guild guild = kawaiiGuilds.getGuildManager().getGuildByLocation(event.getBlock().getLocation());
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());

        if (guild != null) {
            if (!guild.isMember(user)) {
                event.setCancelled(true);
                player.sendMessage(Messages.ERROR$OTHER_GUILD);
            }
        }
    }
}
