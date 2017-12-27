package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.manager.CuboidManager;

public class CuboidManagerImpl implements CuboidManager {

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
        return false;
    }
}
