package io.github.kawaiiguilds.storage.database.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.kawaiiguilds.Config;
import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.data.Guild;
import io.github.kawaiiguilds.data.User;
import io.github.kawaiiguilds.storage.database.AbstractDatabase;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQL extends AbstractDatabase {

    private final HikariDataSource source;
    private final KawaiiGuilds kawaiiGuilds;

    public MySQL(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + Config.MYSQL$HOST + ":"+ Config.MYSQL$PORT +"/" + Config.MYSQL$DATABASE);
        config.setUsername(Config.MYSQL$USER);
        String pass = Config.MYSQL$PASSWORD;
        config.setPassword(pass);

        source = new HikariDataSource(config);

        connect();
    }

    @Override
    protected Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    @Override
    public void connect() {
        try {
            getConnection();
            checkTable();
        } catch (SQLException exception) {
            exception.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(KawaiiGuilds.getProvidingPlugin(KawaiiGuilds.class));
        }
    }

    @Override
    public void disconnect() throws SQLException {
        saveData();
        getConnection().close();
    }

    @Override
    public void reconnect() {
        try {
            if(!isConnection()){
                connect();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean isConnection() throws SQLException {
        return this.getConnection() != null;
    }

    @Override
    public void checkTable() {
        String users = "CREATE TABLE IF NOT EXISTS users(uuid VARCHAR (36) NOT NULL , name VARCHAR (16) NOT NULL , PRIMARY KEY(uuid));";
        String guilds = "CREATE TABLE IF NOT EXISTS guilds(tag VARCHAR (4) NOT NULL, name VARCHAR(16) NOT NULL, PRIMARY KEY(tag));";
        try {
            this.getConnection().prepareStatement("SELECT * FROM `users`").executeUpdate(users);
            this.getConnection().prepareStatement("SELECT * FROM 'guilds'").executeUpdate(guilds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveData() throws SQLException {
        for (User user : kawaiiGuilds.getUserManager().getOnlineUsers()) {
            String users = "INSERT INTO users (uuid, name) VALUES (" +
                    "'" + user.getUUID().toString() + "'," +
                    "'" + user.getName() + "'" +
                    ") ON DUPLICATE KEY UPDATE " +
                    "name='" + user.getName() + "';";

            this.getConnection().prepareStatement("SELECT * FROM `users`").executeUpdate(users);
        }
        for(Guild guild : kawaiiGuilds.getGuildManager().getGuilds()) {
            String guilds = "INSERT INTO guilds (tag, name) VALUES (" +
                    "'" + guild.getTag() + "'," +
                    "'" + guild.getName() + "'" +
                    ") ON DUPLICATE KEY UPDATE " +
                    "tag='" + guild.getTag() + "'," +
                    "name='" + guild.getName() + "';";
            this.getConnection().prepareStatement("SELECT * FROM `guilds`").executeUpdate(guilds);
        }
    }
    @Override
    public void loadData() throws SQLException {

    }

}
