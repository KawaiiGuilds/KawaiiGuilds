package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.data.enums.MessageType;
import io.github.kawaiiguilds.data.User;
import io.github.kawaiiguilds.data.impl.UserImpl;
import io.github.kawaiiguilds.manager.UserManager;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserManagerImpl implements UserManager{

    private final Map<UUID, User> onlineUsers = new ConcurrentHashMap<>();

    @Override
    public Collection<User> getOnlineUsers() {
        return this.onlineUsers.values();
    }

    @Override
    public void createUser(UUID uuid, String name, MessageType messageType) {
        User user = new UserImpl(uuid, name, messageType);
        onlineUsers.put(uuid, new UserImpl(uuid, name, messageType));
    }

    @Override
    public User getUser(UUID uuid) {
        return onlineUsers.get(uuid);
    }

    @Override
    public User getUser(String name) {
        return onlineUsers.values().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }
}
