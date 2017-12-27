package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.data.MessageType;
import io.github.kawaiiguilds.data.User;
import io.github.kawaiiguilds.data.impl.UserImpl;
import io.github.kawaiiguilds.manager.UserManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManagerImpl implements UserManager{

    private final Map<UUID, User> onlineUsers = new HashMap<>();

    public void createUser(UUID uuid, String name, MessageType messageType) {
        if (!onlineUsers.containsKey(uuid)) {
            onlineUsers.put(uuid, new UserImpl(uuid, name, messageType));
        }
        getUser(uuid);
    }

    public User getUser(UUID uuid) {
        return onlineUsers.get(uuid);
    }

    public User getUser(String name) {
        return onlineUsers.values().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }
}
