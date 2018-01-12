package io.github.kawaiiguilds.storage.database;

import io.github.kawaiiguilds.storage.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database {

    void connect();

    void disconnect() throws SQLException;

    void checkUserTable();

    void checkGuildTable();

    void saveUserData() throws SQLException;

    void saveGuildData() throws SQLException;

    void loadUserData() throws SQLException;

    void loadGuildData() throws SQLException;

    void execute(String query) throws SQLException;

    void query(String query, Callback<ResultSet> rs) throws Exception;

}
