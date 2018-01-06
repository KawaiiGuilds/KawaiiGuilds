package io.github.kawaiiguilds.basic;

import org.bukkit.Location;

public interface Guild {

    String getTag();

    void setTag(String tag);

    String getName();

    void setName(String name);

    Cuboid getCuboid();

    Location getBase();

    void setBase(Location loc);

    boolean isPvp();

    void setPvp(boolean pvp);

    void setLeader(User user);

    User getLeader();

    void addInvite(User user);

    boolean hasInvite(User user);

    void removeInvite(User user);
}
