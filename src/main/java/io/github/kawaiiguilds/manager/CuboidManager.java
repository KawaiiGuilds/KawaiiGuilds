package io.github.kawaiiguilds.manager;

import org.bukkit.Location;

public interface CuboidManager {

    int getCenterX();

    int getCenterZ();

    int getSize();

    void setSize(int size);

    default boolean isInCuboid(Location loc) {
        return isInCuboid((int) loc.getX(), (int) loc.getZ());
    }

    boolean isInCuboid(int x, int z);
}
