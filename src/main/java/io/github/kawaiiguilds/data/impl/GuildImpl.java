package io.github.kawaiiguilds.data.impl;

import io.github.kawaiiguilds.data.Cuboid;
import io.github.kawaiiguilds.data.Guild;
import org.bukkit.Location;

public class GuildImpl implements Guild {

    private String tag;
    private String name;
    private int limit;
    private Cuboid cuboid;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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
        //TODO
        return null;
    }

}
