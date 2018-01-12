package io.github.kawaiiguilds.storage;

import io.github.kawaiiguilds.Config;
import io.github.kawaiiguilds.KawaiiGuilds;

import java.io.IOException;
import java.sql.SQLException;

public class StorageImpl implements Storage {

    private final KawaiiGuilds kawaiiGuilds;

    public StorageImpl(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public void loadAll() throws IOException {
        if(Config.USER_STORE.equalsIgnoreCase("mysql")) {
            try {
                this.kawaiiGuilds.getMySQL().loadUserData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(Config.GUILD_STORE.equalsIgnoreCase("mysql")) {
            try {
                this.kawaiiGuilds.getMySQL().loadGuildData();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveAll() throws IOException {
        if(Config.USER_STORE.equalsIgnoreCase("mysql")) {
            try {
                this.kawaiiGuilds.getMySQL().saveUserData();
            } catch (SQLException e) {
                e.printStackTrace();
                //disable plugin
            }
        }else {
            //flat
        }
        if(Config.GUILD_STORE.equalsIgnoreCase("mysql")) {
            try {
                this.kawaiiGuilds.getMySQL().saveGuildData();
            } catch (SQLException e) {
                e.printStackTrace();
                //disable plugin
            }
        }else{
            //flat
        }
    }
}
