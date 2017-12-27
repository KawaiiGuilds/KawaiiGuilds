package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.data.MessageType;
import io.github.kawaiiguilds.data.User;

import java.util.UUID;

public interface UserManager {

    User getUser(UUID uuid);

    User getUser(String name);

    void createUser(UUID uuid, String name, MessageType messageType);

}