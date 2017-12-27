package io.github.kawaiiguilds.data.impl;

import io.github.kawaiiguilds.data.Cuboid;
import org.bukkit.Location;

public class CuboidImpl implements Cuboid {

    private Location guildLocation;
    private int enlargeLevel;
    private Location guildHomeLocation;
    
    @Override
    public int getCenterX() {
        return 0;
    }

    @Override
    public int getCenterZ() {
        return 0;
    }

    @Override
    public Location getGuildLocation() {
        return this.guildLocation;
    }

    @Override
    public int getEnlargeLevel() {
        return this.enlargeLevel;
    }

    @Override
    public Location getGuildHomeLocation() {
        return this.guildHomeLocation;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
