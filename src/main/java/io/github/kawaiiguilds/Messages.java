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
    public static String ERROR$DONT_HAVE_GUILD = "&cNie masz gildii";
    public static String ERROR$PLAYER_HAVE_GUILD = "&cGracz &6{PLAYER} &7jest juz w jakiejs gildii";
    public static String ERROR$TAG = "&cTag moze zawierac tylko litery";
    public static String ERROR$TAG_EXISTS = "&cGildia o tagu &6{TAG} &cjuz istnieje";
    public static String ERROR$TAG_DONT_EXISTS = "&cGildia o tagu &6{TAG} &cnie istnieje";
    public static String ERROR$TAG_MIN_LENGTH = "&cTag nie moze byc dluzszy niz {MINLENGTH} liter";
    public static String ERROR$TAG_MAX_LENGTH = "&cTag nie moze byc krotszy niz {MAXLENGTH} liter";
    public static String ERROR$NAME_EXISTS = "&cGildia o nazwie {NAME} juz istnieje";
    public static String ERROR$NAME_MIN_LENGTH = "&cNazwa nie moze byc krotsza niz {MINLENGTH} litery";
    public static String ERROR$NAME_MAX_LENGTH = "&cNazwa nie moze byc dluzsza niz {MAXLENGTH} liter";
    public static String ERROR$NAME = "&cNazwa moze zawierac tylko litery";
    public static String ERROR$DONT_HAVE_INVITE = "&cNie masz zaproszenia do gildii o tagu &6{TAG}";
    public static String ERROR$OTHER_GUILD = "&cNie mozesz budowac na terenie nie swojej gildii";

    public static String GUILD$CREATED = "&aZalozyles gildiie o tagu &6{TAG}";
    public static String GUILD$CREATED_BROADCAST = "&7Gracz &6{PLAYER} &7zalozyl gildie o tagu &6{TAG} &7i nazwie &6{NAME}";
    public static String GUILD$INVITE$SEND$TO$LEADER = "&7Wyslales zaproszenie do gildii do gracza &6{PLAYER}";
    public static String GUILD$INVITE$SEND$TO$USER = "&7Dostales zaproszenia do gildii o tagu &6{TAG}";
    public static String GUILD$INVITE$CANCELED$TO$LEADER = "&7Zaproszenia gracza &6{PLAYER} &7do gildii zostalo anulowane";
    public static String GUILD$INVITE$CANCELED$TO$USER = "&cZaproszenie do gildii o tagu0 &6{TAG} zostalo anulowane";
    public static String GUILD$JOINED = "&7Dolaczyles do gildii o tagu &6{TAG}";
    public static String GUILD$LEFT = "&cOpusciles gildie o tagu &6{TAG}";

    public static List<String> COMMANDLIST = Arrays.asList(
            "&7<&f-&8[&6KAWAIIGUILDS&8]&f-&8>",
            "&a/g &7zaloz &6<tag> <nazwa>",
            "&a/g &7info &6<tag>",
            "&a/g &7zapros &6<gracz>",
            "&a/g &7dolacz &6<gildia>",
            "&a/g &7usun"
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

