package io.github.kawaiiguilds.manager.impl;

import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.basic.impl.GuildImpl;
import io.github.kawaiiguilds.basic.impl.UserImpl;
import io.github.kawaiiguilds.manager.GuildManager;
import io.github.kawaiiguilds.manager.UserManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserManagerImpl implements UserManager {

    private final Map<UUID, User> users = new ConcurrentHashMap<>();
    private final KawaiiGuilds kawaiiGuilds;

    public UserManagerImpl(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
    }

    @Override
    public Collection<User> getUsers() {
        return this.users.values();
    }

    @Override
    public User getUser(UUID uuid) {
        return this.users.computeIfAbsent(uuid, UserImpl::new);
    }

    @Override
    public User getUser(String name) {
        return this.getUsers().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public void loadUsers(ResultSet rs) {
        try {
            this.kawaiiGuilds.getMySQL().query("SELECT * FROM `users`", (ResultSet result) -> {
                while (result.next()) {
                    User user = new UserImpl(rs);
                    users.put(user.getUUID(), user);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
