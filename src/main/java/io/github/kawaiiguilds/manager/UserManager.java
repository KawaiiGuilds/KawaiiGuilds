package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.enums.MessageType;
import io.github.kawaiiguilds.data.User;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface UserManager {

    Collection<User> getOnlineUsers();

    User getUser(UUID uuid);

    User getUser(String name);

    void createUser(UUID uuid, String name, MessageType messageType);

}