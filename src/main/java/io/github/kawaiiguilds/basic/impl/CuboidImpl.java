package io.github.kawaiiguilds.basic.impl;

import io.github.kawaiiguilds.basic.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class CuboidImpl implements Cuboid {

    private final World world;
    private int centerX;
    private int centerZ;
    private int size;

    public CuboidImpl(String world, int centerX, int centerZ, int size) {
        this.world = Bukkit.getWorld(world);
        this.centerX = centerX;
        this.centerZ = centerZ;
        this.size = size;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public int getCenterX() {
        return this.centerX;
    }

    @Override
    public int getCenterZ() {
        return this.centerZ;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean isInCuboid(int x, int z) {
        return Math.abs(getCenterX() - x) <= size && Math.abs(getCenterZ() - z) <= size;
    }

}
