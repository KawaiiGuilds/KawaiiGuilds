package io.github.kawaiiguilds;

import io.github.kawaiiguilds.configuration.Configuration;
import io.github.kawaiiguilds.configuration.Ignore;

import java.io.File;

public class Config {

    private Config() {
    }

    @Ignore
    private static Configuration configuration;

    public static String REGEX = "[a-zA-Z]+";

    //zapis flat/mysql
    public static String GUILD_STORE = "flat";
    public static String USER_STORE = "flat";
    public static String MYSQL$HOST = "localhost";
    public static int MYSQL$PORT = 3306;
    public static String MYSQL$DATABASE = "database";
    public static String MYSQL$USER = "root";
    public static String MYSQL$PASSWORD = "pass";

    public static int TAG$MIN_LENGTH = 2;
    public static int TAG$MAX_LENGTH = 4;

    public static int NAME$MAX_LENGTH = 16;
    public static int NAME$MIN_LENGTH = 4;

    public static boolean GUILD$CREATED_BROADCAST = true;

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
