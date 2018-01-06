package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.basic.Guild;
import org.bukkit.Location;

import java.util.Collection;

public interface GuildManager {

    void createGuild(Guild guild, Location location);

    Collection<Guild> getGuilds();

    Guild getGuildByTag(String tag);

    Guild getGuildByName(String name);

    boolean tagExists(String tag);
    boolean nameExists(String name);

}
