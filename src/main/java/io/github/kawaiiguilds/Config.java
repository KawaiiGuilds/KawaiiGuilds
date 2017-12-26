package io.github.kawaiiguilds;

import io.github.kawaiiguilds.configuration.Configuration;
import io.github.kawaiiguilds.configuration.Ignore;

import java.io.File;

public class Config {

    private Config(){
    }

    @Ignore
    private static Configuration configuration;

    //zapis flat/mysql
    public static String GUILDSTORE = "flat";
    public static String USERSTORE = "flat";

    public static String MYSQL$HOST = "localhost";
    public static int MYSQL$PORT = 3306;
    public static String MYSQL$DATABASE = "storage";
    public static String MYSQL$USER = "root";
    public static String MYSQL$PASSWORD = "pass";

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
