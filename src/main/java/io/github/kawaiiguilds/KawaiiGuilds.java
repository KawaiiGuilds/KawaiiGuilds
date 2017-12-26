package io.github.kawaiiguilds;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.kawaiiguilds.listener.player.AsyncPlayerChatListener;
import io.github.kawaiiguilds.listener.player.PlayerJoinListener;

import java.util.stream.Stream;

public final class KawaiiGuilds extends JavaPlugin{

    @Override
    public void onEnable(){
         Stream.of(
                new PlayerJoinListener(this), new AsyncPlayerChatListener(this)
        ).forEach(l -> Bukkit.getPluginManager().registerEvents(l, this));
    }

    @Override
    public void onDisable(){

    }


}
