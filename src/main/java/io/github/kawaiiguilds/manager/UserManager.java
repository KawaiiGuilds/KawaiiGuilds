package io.github.kawaiiguilds.manager;

import io.github.kawaiiguilds.basic.User;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.UUID;

public interface UserManager {

    Collection<User> getUsers();

    User getUser(UUID uuid);

    User getUser(String name);

    void loadUsers(ResultSet rs);

}