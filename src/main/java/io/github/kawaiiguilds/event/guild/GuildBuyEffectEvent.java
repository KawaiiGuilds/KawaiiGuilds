package io.github.kawaiiguilds.event.guild;

import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.util.effect.EffectType;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;

public final class GuildBuyEffectEvent extends Event implements Cancellable {

    private EffectType effectType;
    private Guild guild;
    private boolean cancelled;
    private static final HandlerList handlers = new HandlerList();

    public GuildBuyEffectEvent(EffectType effectType, Guild guild) {
        this.effectType = effectType;
        this.guild = guild;
    }

    public void setEffectType() {
        this.effectType = effectType;
    }

    public EffectType getEffectType() {
        return this.effectType;
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
