package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.storage.database.AbstractDatabase;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.UUID;

public interface GuildManager{

    Collection<Guild> getGuilds();

    Guild createGuild(String tag, String name, User user);

    Guild getGuildByTag(String tag);

    Guild getGuildByName(String name);

    Guild getGuildByLocation(Location location);

    default Guild getGuildByPlayer(User user) {
        return getGuildByPlayer(user.getUUID());
    }

    default Guild getGuildByPlayer(Player player) {
        return getGuildByPlayer(player.getUniqueId());
    }

    Guild getGuildByPlayer(UUID uuid);

    void loadGuilds(ResultSet rs);

    boolean tagExists(String tag);

    boolean nameExists(String name);

}
