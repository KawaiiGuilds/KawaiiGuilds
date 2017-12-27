package io.github.kawaiiguilds.data;

import org.bukkit.Location;

public interface Cuboid {

    int getCenterX();

    int getCenterZ();

    int getSize();

    void setSize(int size);

    default boolean isInCuboid(Location loc) {
        return isInCuboid((int) loc.getX(), (int) loc.getZ());
    }

    boolean isInCuboid(int x, int z);
}
