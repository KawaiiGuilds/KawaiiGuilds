package io.github.kawaiiguilds.data.impl;

import io.github.kawaiiguilds.data.Cuboid;
import io.github.kawaiiguilds.data.Guild;
import org.bukkit.Location;

import java.util.Optional;

public class GuildImpl implements Guild {

    private String tag;
    private String name;
    private Cuboid cuboid;
    private Location base;
    private boolean pvp;

    public GuildImpl(String tag, String name, Cuboid cuboid) {
        this.tag = tag;
        this.name = name;
        this.cuboid = cuboid;
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Cuboid getCuboid() {
        return this.cuboid;
    }

    @Override
    public Optional<Location> getHome() {
        return Optional.ofNullable(this.base);
    }

    @Override
    public void setHome(Location loc) {
        this.base = loc;
    }

    @Override
    public boolean isPvp() {
        return this.pvp;
    }

    @Override
    public void setPvp(boolean pvp) {
        this.pvp = pvp;
    }

}
