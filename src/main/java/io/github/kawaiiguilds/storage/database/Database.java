package io.github.kawaiiguilds.storage.database;

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

    void execute(String query) throws Exception;

    void query(String query, ResultSet result) throws Exception;

}
