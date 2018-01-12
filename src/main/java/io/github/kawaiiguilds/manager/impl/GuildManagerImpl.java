package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.basic.impl.GuildImpl;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.util.GuildCreateUtil;
import org.bukkit.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GuildManagerImpl implements GuildManager {

    private final Map<String, Guild> guilds = new ConcurrentHashMap<>();
    private final KawaiiGuilds kawaiiGuilds;

    public GuildManagerImpl(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public Collection<Guild> getGuilds() {
        return this.guilds.values();
    }

    @Override
    public Guild createGuild(String tag, String name, User user) {
        Guild guild = new GuildImpl(tag, name);
        user.setGuild(guild);
        guild.addMember(user);
        guild.setLeader(user);
        guild.setBase(user.getPlayer().getLocation());
        GuildCreateUtil.createBaseGuild(user.getPlayer().getLocation());
        this.guilds.put(tag, guild);

        return guild;
    }

    @Override
    public Guild getGuildByTag(String tag) {
        return this.guilds.get(tag);
    }

    @Override
    public Guild getGuildByName(String name) {
        return this.getGuilds().stream()
                .filter(guild -> guild.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public Guild getGuildByLocation(Location location) {
        return this.getGuilds().stream()
                .filter(guild -> guild.getCuboid().isInCuboid(location))
                .findAny()
                .orElse(null);
    }

    @Override
    public Guild getGuildByPlayer(UUID uuid) {
        return this.getGuilds().stream()
                .filter(guild -> guild.isMember(uuid))
                .findAny()
                .orElse(null);
    }

    @Override
    public void loadGuilds(ResultSet rs) {
        try {
            this.kawaiiGuilds.getMySQL().query("SELECT * FROM `guilds`", (ResultSet result) -> {
                while (result.next()) {
                    Guild guild = new GuildImpl(rs);
                    guilds.put(guild.getTag(), guild);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean tagExists(String tag) {
        return this.guilds.containsKey(tag);
    }

    @Override
    public boolean nameExists(String name) {
        return this.getGuildByName(name) != null;

    }


}
