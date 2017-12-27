package io.github.kawaiiguilds.event.user;

import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.data.User;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class UserLeaveGuildEvent extends Event implements Cancellable {

    private final User user;
    private final Guild guild;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public UserLeaveGuildEvent(User user, Guild guild) {
        this.user = user;
        this.guild = guild;
    }

    public User getUser() {
        return this.user;
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
