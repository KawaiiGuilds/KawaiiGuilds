package io.github.kawaiiguilds.data;

import org.bukkit.Location;

public interface Cuboid {

    Location getGuildLocation();

    int getEnlargeLevel();

    Location getGuildHomeLocation();

    int getCenterX();

    int getCenterZ();

    int getSize();

}
