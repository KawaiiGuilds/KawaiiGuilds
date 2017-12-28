package io.github.kawaiiguilds.data;

import org.bukkit.Location;

import java.util.Optional;

public interface Guild {

    String getTag();
    void setTag(String tag);

    String getName();
    void setName(String name);

    Cuboid getCuboid();

    Optional<Location> getHome();

    void setHome(Location loc);

    boolean isPvp();

    void setPvp(boolean pvp);

}
