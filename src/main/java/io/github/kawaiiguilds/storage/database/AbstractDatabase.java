package io.github.kawaiiguilds.storage.database;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDatabase implements Database {

    protected abstract Connection getConnection() throws SQLException;

}
