package io.github.kawaiiguilds.listener;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.util.ColorUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    private final KawaiiGuilds kawaiiGuilds;

    public AsyncPlayerChatListener(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onAsyncPlayerChatEvent(final AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
        String format = "{TAG} &7{PLAYER} &8> &f{MSG}";

        format = StringUtils.replace(format, "{PLAYER}", player.getName());
        format = StringUtils.replace(format, "{MSG}", event.getMessage());

        if(user.hasGuild()) {
            format = StringUtils.replace(format, "{TAG}", "&8[&c" + user.getGuild().getTag() + "&8]");
        } else {
            format = StringUtils.replace(format, "{TAG}", "");
        }

        event.setFormat(ColorUtil.fixColor(format));
    }
}
