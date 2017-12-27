package io.github.kawaiiguilds.event.guild;

import io.github.kawaiiguilds.data.Guild;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class GuildEnlargeUserLimit extends Event implements Cancellable {

    private int limit; //maximum == 30
    private final Guild guild;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public GuildEnlargeUserLimit(int limit, Guild guild) {
        this.limit = limit;
        this.guild = guild;
    }

    public void setLimit() {
        this.limit = limit;
    }

    public int getLimit() {
        return this.limit;
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
