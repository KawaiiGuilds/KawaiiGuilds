package io.github.kawaiiguilds.data.impl;

import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.data.enums.MessageType;
import io.github.kawaiiguilds.data.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public class UserImpl implements User {

    private final UUID uuid;
    private final String name;
    private Guild guild;
    private MessageType messageType;
    private int kills;
    private int deaths;
    private int points;

    public UserImpl(UUID uuid, String name, MessageType messageType) {
        this.uuid = uuid;
        this.name = name;
        this.messageType = messageType;
    }
    @Override
    public MessageType getMessageType() {
        return messageType;
    }
    @Override
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
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
    public Optional<Player> getPlayer() {
        return Optional.ofNullable(Bukkit.getPlayer(uuid));
    }

    @Override
    public Optional<Guild> getGuild() {
        return Optional.ofNullable(this.guild);
    }
}
