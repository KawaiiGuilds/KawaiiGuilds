package io.github.kawaiiguilds.tablist.variable.user;

import codecrafter47.bungeetablistplus.api.bukkit.Variable;
import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.User;
import org.bukkit.entity.Player;

public class KillsVariable extends Variable {

    private final KawaiiGuilds kawaiiGuilds;

    public KillsVariable(KawaiiGuilds kawaiiGuilds) {
        super("kills");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public String getReplacement(Player player) {
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
        return Integer.toString(user.getKills());
    }
}
