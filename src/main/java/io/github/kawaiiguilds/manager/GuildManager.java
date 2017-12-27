package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.Guild;

import java.util.ArrayList;
import java.util.List;

public class GuildManager {

    private static List<Guild> guildList = new ArrayList<>();

    public static List<Guild> getGuildList() {
        return guildList;
    }

    public static boolean tagExists(String tag) {
        for (Guild guild : guildList) {
            if (guild.getTag().equalsIgnoreCase(tag)) {
                return true;
            }
        }
        return false;
    }

    public static boolean nameExists(String name) {
        for (Guild guild : guildList) {
            if (guild.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
