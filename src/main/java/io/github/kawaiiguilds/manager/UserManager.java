package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class UserManager{

    private static final Map<UUID, User> usersMap = new HashMap<>();

    public static void createUser(UUID uuid, String name){
        if (!usersMap.containsKey(uuid)) {
            usersMap.put(uuid, new User(uuid, name));
        }
        getUser(uuid);
    }

    public static User getUser(UUID uuid){
        return usersMap.get(uuid);
    }

    public User getUser(String name){
        return usersMap.values().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .map(Optional::ofNullable)
                .findFirst()
                .flatMap(Function.identity())
                .orElse(null);
    }
}
