package io.github.kawaiiguilds.tablist.variable.guild;

import codecrafter47.bungeetablistplus.api.bukkit.Variable;
import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.User;
import org.bukkit.entity.Player;

public class TagVariable extends Variable {

    private final KawaiiGuilds kawaiiGuilds;

    public TagVariable(KawaiiGuilds kawaiiGuilds) {
        super("gtag");
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public String getReplacement(Player player) {
        User user = kawaiiGuilds.getUserManager().getUser(player.getUniqueId());
        if (user.hasGuild()) {
            return user.getGuild().getTag();
        }
    return "";
    }
}
