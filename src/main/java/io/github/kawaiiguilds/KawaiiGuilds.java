package io.github.kawaiiguilds;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.kawaiiguilds.listener.player.AsyncPlayerChatListener;
import io.github.kawaiiguilds.listener.player.PlayerJoinListener;

import java.io.File;
import java.util.stream.Stream;

public final class KawaiiGuilds extends JavaPlugin{

    @Override
    public void onEnable(){
        Messages.init(new File(this.getDataFolder(), "messages.yml"));
        Config.init(new File(this.getDataFolder(), "config.yml"));
         Stream.of(
                new PlayerJoinListener(), new AsyncPlayerChatListener()
        ).forEach(l -> Bukkit.getPluginManager().registerEvents(l, this));
    }

    @Override
    public void onDisable(){

    }


}
