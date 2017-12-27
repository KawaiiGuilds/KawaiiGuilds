package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class UserManager{

    private static final Map<UUID, User> onlineUsers= new HashMap<>();

    public static void createUser(UUID uuid, String name) {
        if (!onlineUsers.containsKey(uuid)) {
            onlineUsers.put(uuid, new User(uuid, name));
        }
        getUser(uuid);
    }

    public static User getUser(UUID uuid) {
        return onlineUsers.get(uuid);
    }

    public User getUser(String name) {
        return onlineUsers.values().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .map(Optional::ofNullable)
                .findFirst()
                .flatMap(Function.identity())
                .orElse(null);
    }
}
