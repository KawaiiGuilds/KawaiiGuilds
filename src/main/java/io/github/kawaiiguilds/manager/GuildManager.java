package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.Guild;
import java.util.Collection;

public interface GuildManager {

    void createGuild(Guild guild);

    Collection<Guild> getGuilds();

    Guild getGuildByTag(String tag);

    Guild getGuildByName(String name);

    boolean tagExists(String tag);
    boolean nameExists(String name);

}
