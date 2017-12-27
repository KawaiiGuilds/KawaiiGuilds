package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.Guild;

import java.util.Map;

public interface GuildManager {

    Map<String, Guild> getGuilds();
    boolean tagExists(String tag);
    boolean nameExists(String name);


}
