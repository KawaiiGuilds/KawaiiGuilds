package io.github.kawaiiguilds.event.user;

import io.github.kawaiiguilds.data.User;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class UserTeleportGuildHomeEvent extends Event implements Cancellable {

    private final User user;
    private final Location guildHomeLocation;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public UserTeleportGuildHomeEvent(User user, Location location) {
        this.user = user;
        this.guildHomeLocation = location;
    }

    public User getUser() {
        return this.user;
    }

    public Location getGuildHomeLocation() {
        return guildHomeLocation;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean bln) {
        this.cancelled = bln;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
