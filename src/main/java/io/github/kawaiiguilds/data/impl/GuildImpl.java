package io.github.kawaiiguilds.data.impl;

import io.github.kawaiiguilds.data.Cuboid;
import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.data.User;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildImpl implements Guild {

    private String tag;
    private String name;
    private Cuboid cuboid;
    private User leader;
    private List<User> members = new ArrayList<>();
    private Location base;
    private boolean pvp;


    public GuildImpl(String tag, String name, User leader, Location location) {
        this.tag = tag;
        this.name = name;
        this.leader = leader;
        this.base = location;
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
    public User getLeader() {
        return this.leader;
    }

    @Override
    public User setLeader(User user) {
        return this.leader = user;
    }

    @Override
    public Location getBase() {
        return this.base;
    }

    @Override
    public void setBase(Location loc) {
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
