package io.github.kawaiiguilds.manager.util;

import io.github.kawaiiguilds.util.SpaceUtil;
import org.bukkit.Location;
import org.bukkit.Material;

public class GuildCreateUtil {

    private GuildCreateUtil() {
    }

    public static void createBaseGuild(Location location) {
        Location c = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
        c.setY(c.getY() - 1);
        for (Location loc : SpaceUtil.getSquare(c, 4, 3)) {
            loc.getBlock().setType(Material.AIR);
        }
        for (Location loc : SpaceUtil.getSquare(c, 3)) {
            loc.getBlock().setType(Material.OBSIDIAN);
        }
        for (Location loc : SpaceUtil.getCorners(c, 3, 3)) {
            loc.getBlock().setType(Material.OBSIDIAN);
        }
        c.add(0, 4, 0);
        for (Location loc : SpaceUtil.getWalls(c, 3)) {
            loc.getBlock().setType(Material.OBSIDIAN);
        }
        c = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
        c.getBlock().setType(Material.DRAGON_EGG);
        c.setY(c.getY() - 1);
        c.getBlock().setType(Material.BEDROCK);

    }

}
