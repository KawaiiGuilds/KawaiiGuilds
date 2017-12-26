package io.github.kawaiiguilds;

import io.github.kawaiiguilds.configuration.Configuration;
import io.github.kawaiiguilds.configuration.Ignore;

import java.io.File;

public class Config {

    private Config(){
    }

    @Ignore
    private static Configuration configuration;



    public static void init(File file) {
        configuration = new Configuration(file, Config.class);
    }

    public static void reloadConfig() {
        configuration.reloadConfig();
    }

    public static void saveConfig() {
        configuration.saveConfig();
    }
}
