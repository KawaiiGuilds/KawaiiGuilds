package io.github.kawaiiguilds.data;

import org.bukkit.World;

public class Cuboid {

    private Guild guild;
    private World world;
    private int centerX;
    private int centerZ;
    private int size;

    public Guild getGuild() {
        return guild;
    }

    public World getWorld() {
        return world;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterZ() {
        return centerZ;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
