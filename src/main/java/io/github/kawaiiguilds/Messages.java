package io.github.kawaiiguilds;

import io.github.kawaiiguilds.configuration.Configuration;
import io.github.kawaiiguilds.configuration.Ignore;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Messages {

    private Messages() {
    }

    @Ignore
    private static Configuration configuration;

    public static String NOPERMISSION = "&cNie masz permisji mordo ;/";

    public static String ERROR$NO_PLAYER = "&cNie znaleziono gracza &7{PLAYER}";
    public static String ERROR$HAS_GUILD = "&cMasz juz gildie";
    public static String ERROR$TAG_EXISTS = "&cGildia o tagu &7{TAG} &cjuz istnieje";
    public static String ERROR$TAG_MIN_LENGTH = "&cTag nie moge byc dluzsza niz {MAXLENGTH} liter";
    public static String ERROR$TAG_MAX_LENGTH = "&cTag nie moge byc krotszy niz {MINLENGTH} liter";
    public static String ERROR$NAME_EXISTS = "&cGildia o nazwie {NAME} juz istnieje";
    public static String ERROR$NAME_MAX_LENGTH = "&cNazwa nie moze byc dluzsza niz {MAXLENGTH} liter";
    public static String ERROR$NAME_MIN_LENGTH = "&cNazwa nie moze byc krotsza niz {MINLENGTH} litery";
    public static String ERROR$NAME = "&cNazwa moze zawierac tylko litery";
    public static String ERROR$TAG= "&cTag moze zawierac tylko litery";
    public static String GUILD$CREATED = "&aZalozyles gildiie o tagu &6{TAG}";

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

