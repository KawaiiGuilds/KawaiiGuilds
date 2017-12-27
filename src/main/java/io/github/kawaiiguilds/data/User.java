package io.github.kawaiiguilds.data;

import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public interface User {

    UUID getUUID();

    String getName();

    Optional<Player> getPlayer();

    Optional<Guild> getGuild();

    MessageType getMessageType();

    void setMessageType(MessageType messageType);
}
