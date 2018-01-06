package io.github.kawaiiguilds.tablist.variable.guild;

import codecrafter47.bungeetablistplus.api.bukkit.Variable;
import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.User;
import org.bukkit.entity.Player;

public class NameVariable extends Variable {

    private final KawaiiGuilds kawaiiGuilds;

    public NameVariable(KawaiiGuilds kawaiiGuilds) {
        super("gname");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public String getReplacement(Player player) {
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
        if (user.hasGuild()) {
            return user.getGuild().getName();
        }
        return "";
    }
}