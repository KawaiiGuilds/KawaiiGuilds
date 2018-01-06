package io.github.kawaiiguilds.basic.impl;

import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public class UserImpl implements User {

    private final UUID uuid;
    private final String name;
    private Guild guild;
    private int kills;
    private int deaths;
    private int points;

    public UserImpl(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    @Override
    public int getKills() {
        return this.kills;
    }

    @Override
    public void setKills(int kills) {
        this.kills = kills;
    }

    @Override
    public int getDeaths() {
        return this.deaths;
    }

    @Override
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void sendMessage(String message) {
        MessageUtil.sendMessage(getPlayer(), message);
    }

    @Override
    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    @Override
    public Guild getGuild() {
        return this.guild;
    }

    @Override
    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    @Override
    public boolean hasGuild() {
        return this.guild == null;
    }

}
