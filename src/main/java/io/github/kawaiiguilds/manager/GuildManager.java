package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.Guild;

import java.util.List;

public interface GuildManager {

    List<Guild> getGuildList();
    boolean tagExists(String tag);
    boolean nameExists(String name);


}
