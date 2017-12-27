package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {

    private final Map<UUID, User> usersMap = new HashMap<>();

    public User createUser(UUID uuid, String name){
        if (!this.usersMap.containsKey(uuid)) {
            this.usersMap.put(uuid, new User(uuid, name));
        }
        return this.getUser(uuid);
    }

    public User getUser(UUID uuid){
        return this.usersMap.get(uuid);
    }

    public User getUser(String name){
        return this.usersMap.values()
                .stream()
                .filter(Player -> Player.getName().equalsIgnoreCase(name))
                .findFirst()
                .get();
    }
}
