package io.github.kawaiiguilds.basic;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface User {

    UUID getUUID();

    String getName();

    void sendMessage(String message);

    int getKills();

    void setKills(int kills);

    int getDeaths();

    void setDeaths(int deaths);

    int getPoints();

    void setPoints(int points);

    Player getPlayer();

    Guild getGuild();

    void setGuild(Guild guild);

    boolean hasGuild();
}
