package io.github.kawaiiguilds.storage.database;

import io.github.kawaiiguilds.storage.Callback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDatabase implements Database {

    protected abstract Connection getConnection() throws SQLException;

    public abstract void execute(String query) throws SQLException;

    public abstract void query(String query, Callback<ResultSet> rs) throws Exception;

}
