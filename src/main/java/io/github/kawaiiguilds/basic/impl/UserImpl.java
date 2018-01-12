package io.github.kawaiiguilds.basic.impl;

import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;

public class UserImpl implements User {

    private final UUID uuid;
    private String name;
    private Guild guild;
    private int kills;
    private int deaths;
    private int points;

    public UserImpl(UUID uuid) {
        this.uuid = uuid;
        this.name = Bukkit.getOfflinePlayer(uuid).getName();
    }

    public UserImpl(ResultSet rs) throws SQLException {
        this.uuid = UUID.fromString(rs.getString("uuid"));
        this.name = rs.getString("name");
        this.points = rs.getInt("points");
        this.kills = rs.getInt("kills");
        this.deaths = rs.getInt("deaths");
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
    public void setName(String name) {
        this.name = name;
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
        return this.guild != null;
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
}
