package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.manager.GuildManager;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GuildManagerImpl implements GuildManager {

    private final Map<String, Guild> guilds = new ConcurrentHashMap<>();

    @Override
    public Collection<Guild> getGuilds() {
        return this.guilds.values();
    }

    @Override
    public Guild getGuildByTag(String tag) {
        return this.guilds.get(tag);
    }

    @Override
    public Guild getGuildByName(String name) {
        return getGuilds().stream()
                .filter(guild -> guild.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }


    @Override
    public boolean tagExists(String tag) {
        for(Guild guild : this.guilds.values()) {
            if (guild.getTag().equalsIgnoreCase(tag)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean nameExists(String name) {
        for (Guild guild : this.guilds.values()) {
            if (guild.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
