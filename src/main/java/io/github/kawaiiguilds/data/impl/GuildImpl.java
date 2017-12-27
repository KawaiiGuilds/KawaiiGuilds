package io.github.kawaiiguilds.data.impl;

import io.github.kawaiiguilds.data.Guild;

public class GuildImpl implements Guild {

    private String tag;
    private String name;

    @Override
    public String getTag() {
        return this.tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
