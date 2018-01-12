package io.github.kawaiiguilds.storage.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDatabase implements Database {

    protected abstract Connection getConnection() throws SQLException;

    public abstract void execute(String query) throws Exception;

    public abstract void query(String query, Callback<ResultSet> result) throws Exception;

}
