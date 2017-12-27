package io.github.kawaiiguilds.data;

import java.util.UUID;

public class User {

    private final UUID uuid;
    private String name;
    private Guild guild;

    public User(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guild getGuild() {
        return guild;
    }
}
