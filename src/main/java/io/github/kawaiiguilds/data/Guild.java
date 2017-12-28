package io.github.kawaiiguilds.data;

import org.bukkit.Location;

public interface Guild {

    String getTag();
    void setTag(String tag);

    String getName();
    void setName(String name);

    Cuboid getCuboid();

    User getLeader();
    User setLeader(User user);

    Location getBase();

    void setBase(Location loc);

    boolean isPvp();

    void setPvp(boolean pvp);

}
