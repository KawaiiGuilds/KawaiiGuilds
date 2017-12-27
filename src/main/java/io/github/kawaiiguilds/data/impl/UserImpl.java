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
