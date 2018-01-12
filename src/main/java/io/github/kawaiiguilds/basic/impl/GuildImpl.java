package io.github.kawaiiguilds.basic.impl;

import io.github.kawaiiguilds.basic.Cuboid;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import org.bukkit.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GuildImpl implements Guild {

    private String tag;
    private String name;
    private Cuboid cuboid;
    private User leader;
    private Location base;
    private boolean pvp;
    private final Map<UUID, User> members = new ConcurrentHashMap<>();
    private final Collection<UUID> invites = new ArrayList<>();

    public GuildImpl(String tag, String name) {
        this.tag = tag;
        this.name = name;
    }

    public GuildImpl(ResultSet rs) throws SQLException {
        this.tag = rs.getString("tag");
        this.name = rs.getString("name");
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

    @Override
    public void setLeader(User user) {
        this.addMember(user);
    }

    @Override
    public User getLeader() {
        return this.leader;
    }

    @Override
    public void addInvite(User user) {
        this.invites.add(user.getUUID());
    }

    @Override
    public boolean hasInvite(User user) {
        return invites.contains(user.getUUID());
    }

    @Override
    public void removeInvite(User user) {
        this.invites.remove(user.getUUID());
    }

    @Override
    public void addMember(User user) {
        this.members.put(user.getUUID(), user);
    }

    @Override
    public void removeMember(User user) {
        this.members.remove(user.getUUID());
    }

    @Override
    public boolean isMember(UUID uuid) {
        return members.keySet().contains(uuid);
    }

    @Override
    public Map<UUID, User> getMembers() {
        return this.members;
    }
}
