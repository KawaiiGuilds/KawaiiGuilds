package io.github.kawaiiguilds.storage.database;

import java.sql.SQLException;

public interface Database {

    void connect();

    void disconnect() throws SQLException;

    void reconnect() throws SQLException;

    boolean isConnection() throws SQLException;

    void checkTable();

    void saveUserData() throws SQLException;

    void saveGuildData() throws SQLException;

    void loadUserData() throws SQLException;

    void loadGuildData() throws SQLException;
}
