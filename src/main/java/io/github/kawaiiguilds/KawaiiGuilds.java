package io.github.kawaiiguilds;

import org.bukkit.plugin.java.JavaPlugin;
import io.github.kawaiiguilds.listener.player.AsyncPlayerChatListener;
import io.github.kawaiiguilds.listener.player.PlayerJoinListener;

public final class KawaiiGuilds extends JavaPlugin{

    @Override
    public void onEnable(){
         Stream.of(
                new PlayerJoinListener(), AsyncPlayerChatListener()
        ).forEach(l -> Bukkit.getPluginManager().registerEvents(l, this));
    }

    @Override
    public void onDisable(){

    }


}
