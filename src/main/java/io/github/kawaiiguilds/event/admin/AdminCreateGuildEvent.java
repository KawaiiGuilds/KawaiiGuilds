package io.github.kawaiiguilds.event.admin;

import io.github.kawaiiguilds.data.Guild;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;

public final class AdminCreateGuildEvent extends Event implements Cancellable {

    private Guild guild;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public AdminCreateGuildEvent(Guild guild) {
        this.guild = guild;
    }

    public void setGuild() {
        this.guild = guild;
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
