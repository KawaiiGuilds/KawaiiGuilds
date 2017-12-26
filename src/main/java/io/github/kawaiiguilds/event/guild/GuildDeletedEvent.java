package io.github.kawaiiguilds.event.guild;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GuildDeletedEvent extends Event{

    private static final HandlerList handlerList = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
