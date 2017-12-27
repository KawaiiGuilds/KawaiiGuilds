package io.github.kawaiiguilds;

import io.github.kawaiiguilds.configuration.Configuration;
import io.github.kawaiiguilds.configuration.Ignore;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Messages{

    private Messages(){
    }

    @Ignore
    private static Configuration configuration;

    public static String NOPERMISSION = "&cNie masz permisji mordo ;/";
    public static String HASGUILD = "&cMasz juz gildie ;/";
    public static String TAGEXISTS = "&cGildia o tym tagu juz istnieje";
    public static String NAMEEXISTS = "&cGildia o tym nicku juz istnieje";
    public static List<String> COMMANDLIST = Arrays.asList(
            "&7<&f-&8[&6KAWAIIGUILDS&8]&f-&8>",
            "&a/g &7zaloz &6<tag> <nazwa>",
            "&a/g &7info &6<tag>"
    );

    public static void init(File file) {
        configuration = new Configuration(file, Messages.class);
    }

    public static void reloadConfig() {
        configuration.reloadConfig();
    }

    public static void saveConfig() {
        configuration.saveConfig();
    }
}

