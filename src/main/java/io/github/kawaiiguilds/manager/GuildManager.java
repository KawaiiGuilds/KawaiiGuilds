package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.Guild;

import java.util.Collection;
import java.util.Map;

public interface GuildManager {

    Collection<Guild> getGuilds();

    public Guild getGuildByTag(String tag);

    public Guild getGuildByName(String name);

    boolean tagExists(String tag);
    boolean nameExists(String name);

}
