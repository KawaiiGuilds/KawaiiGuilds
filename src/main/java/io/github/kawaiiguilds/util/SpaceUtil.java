package io.github.kawaiiguilds.util;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class SpaceUtil {

    private SpaceUtil() {
    }

    public static List<Location> getSphere(Location loc, int radius, int height, boolean hollow, boolean sphere, int plusY){
        List<Location> circleblocks = new ArrayList<>();
        int cx = loc.getBlockX();
        int cy = loc.getBlockY();
        int cz = loc.getBlockZ();
        for(int x = cx - radius; x <= cx + radius; x++){
            for (int z = cz - radius; z <= cz + radius; z++){
                for(int y = (sphere ? cy - radius : cy); y < (sphere ? cy + radius : cy + height); y++){
                    double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);
                    if(dist < radius * radius && !(hollow && dist < (radius - 1) * (radius - 1))){
                        Location l = new Location(loc.getWorld(), x, y + plusY, z);
                        circleblocks.add(l);
                    }
                }
            }
        }
        return circleblocks;
    }
    public static List<Location> getSquare(Location center, int radius) {
        List<Location> locs = new ArrayList<>();
        int cX = center.getBlockX();
        int cZ = center.getBlockZ();
        int minX = Math.min(cX + radius, cX - radius);
        int maxX = Math.max(cX + radius, cX - radius);
        int minZ = Math.min(cZ + radius, cZ - radius);
        int maxZ = Math.max(cZ + radius, cZ - radius);

        for (int x = minX; x <= maxX; x++)
            for (int z = minZ; z <= maxZ; z++)
                locs.add(new Location(center.getWorld(), x, center.getBlockY(), z));
        locs.add(center);
        return locs;
    }

    public static List<Location> getCorners(Location center, int radius) {
        List<Location> locs = new ArrayList<>();
        int cX = center.getBlockX();
        int cZ = center.getBlockZ();
        int minX = Math.min(cX + radius, cX - radius);
        int maxX = Math.max(cX + radius, cX - radius);
        int minZ = Math.min(cZ + radius, cZ - radius);
        int maxZ = Math.max(cZ + radius, cZ - radius);

        locs.add(new Location(center.getWorld(), minX, center.getBlockY(), minZ));
        locs.add(new Location(center.getWorld(), maxX, center.getBlockY(), minZ));
        locs.add(new Location(center.getWorld(), minX, center.getBlockY(), maxZ));
        locs.add(new Location(center.getWorld(), maxX, center.getBlockY(), maxZ));
        return locs;
    }

    public static List<Location> getWalls(Location center, int radius) {
        List<Location> locs = getSquare(center, radius);
        locs.removeAll(getSquare(center, radius - 1));
        return locs;
    }

    public static List<Location> getSquare(Location center, int radius, int height) {
        List<Location> locs = getSquare(center, radius);
        for (int i = 1; i <= height; i++)
            locs.addAll(getSquare(new Location(center.getWorld(), center.getBlockX(), center.getBlockY() + i, center.getBlockZ()), radius));
        return locs;
    }

    public static List<Location> getCorners(Location center, int radius, int height) {
        List<Location> locs = getCorners(center, radius);
        for (int i = 1; i <= height; i++)
            locs.addAll(getCorners(new Location(center.getWorld(), center.getBlockX(), center.getBlockY() + i, center.getBlockZ()), radius));
        return locs;
    }

}
