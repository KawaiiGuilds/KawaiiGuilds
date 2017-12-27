package io.github.kawaiiguilds.event.guild;

import io.github.kawaiiguilds.data.Guild;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class GuildEnlargeTerrain extends Event implements Cancellable {

    private int enlargeLevel; // maximum == 5
    private Guild guild;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public GuildEnlargeTerrain(int enlargeLevel, Guild guild) {
        this.enlargeLevel = enlargeLevel;
        this.guild = guild;
    }

    public void setEnlargeLevel() {
        this.enlargeLevel = enlargeLevel;
    }

    public int getEnlargeLevel() {
        return this.enlargeLevel;
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
