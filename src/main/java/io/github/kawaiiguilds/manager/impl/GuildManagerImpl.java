package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.manager.GuildManager;

import java.util.ArrayList;
import java.util.List;

public class GuildManagerImpl implements GuildManager {

    private List<Guild> guildList = new ArrayList<>();

    @Override
    public List<Guild> getGuildList() {
        return guildList;
    }

    @Override
    public boolean tagExists(String tag) {
        for (Guild guild : this.guildList) {
            if (guild.getTag().equalsIgnoreCase(tag)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean nameExists(String name) {
        for (Guild guild : this.guildList) {
            if (guild.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
