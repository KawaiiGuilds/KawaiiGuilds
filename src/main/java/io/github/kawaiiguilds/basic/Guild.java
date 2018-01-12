package io.github.kawaiiguilds.basic;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    void addMember(User user);

    void removeMember(User user);

    default boolean isMember(User user) {
        return isMember(user.getUUID());
    }

    default boolean isMember(Player player) {
        return isMember(player.getUniqueId());
    }

    boolean isMember(UUID uuid);

    Map<UUID, User> getMembers();

    void setLeader(User user);

    User getLeader();

    void addInvite(User user);

    boolean hasInvite(User user);

    void removeInvite(User user);


}
