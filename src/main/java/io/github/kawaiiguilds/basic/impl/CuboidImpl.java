package io.github.kawaiiguilds.basic.impl;

import io.github.kawaiiguilds.basic.Cuboid;

public class CuboidImpl implements Cuboid {

    private int centerX;
    private int centerZ;
    private int size;

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
