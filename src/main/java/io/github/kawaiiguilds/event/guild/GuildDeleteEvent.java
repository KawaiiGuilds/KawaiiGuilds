package io.github.kawaiiguilds.event.guild;

import io.github.kawaiiguilds.data.Guild;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GuildDeleteEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final Guild guild;

    public GuildDeleteEvent(Guild guild) {
        this.guild = guild;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
