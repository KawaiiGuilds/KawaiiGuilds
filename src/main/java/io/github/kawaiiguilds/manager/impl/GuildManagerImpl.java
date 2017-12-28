package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.data.User;
import io.github.kawaiiguilds.data.impl.GuildImpl;
import io.github.kawaiiguilds.manager.GuildManager;
import org.bukkit.Location;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GuildManagerImpl implements GuildManager {

    private final Map<String, Guild> guilds = new ConcurrentHashMap<>();

    @Override
    public void createGuild(Guild guild) {
        this.guilds.put(guild.getTag(), guild);
    }

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
