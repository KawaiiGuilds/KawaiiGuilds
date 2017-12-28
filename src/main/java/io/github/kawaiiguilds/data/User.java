package io.github.kawaiiguilds.data;

import io.github.kawaiiguilds.data.enums.MessageType;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public interface User {

    UUID getUUID();

    String getName();

    MessageType getMessageType();

    void setMessageType(MessageType messageType);

    int getKills();

    void setKills(int kills);

    int getDeaths();

    void setDeaths(int deaths);

    int getPoints();

    void setPoints(int points);

    Optional<Player> getPlayer();

    Guild getGuild();

    void setGuild(Guild guild);
}
