package io.github.kawaiiguilds.event.guild;

import io.github.kawaiiguilds.data.Guild;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;

public final class GuildCreateEvent extends Event implements Cancellable {

    private Location guildLocation;
    private Guild guild;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public GuildCreateEvent(Location guildLocation, Guild guild) {
        this.guildLocation = guildLocation;
        this.guild = guild;
    }

    public void setGuildLocation() {
        this.guildLocation = guildLocation;
    }

    public Location getGuildLocation() {
        return this.guildLocation;
    }

    public Guild getGuild() {
        return this.guild;
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
