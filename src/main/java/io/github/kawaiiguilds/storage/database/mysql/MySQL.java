package io.github.kawaiiguilds.storage.database.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.kawaiiguilds.Config;
import io.github.kawaiiguilds.KawaiiGuilds;
import io.github.kawaiiguilds.basic.Guild;
import io.github.kawaiiguilds.basic.User;
import io.github.kawaiiguilds.storage.Callback;
import io.github.kawaiiguilds.storage.database.AbstractDatabase;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class MySQL extends AbstractDatabase {

    private final HikariDataSource source;
    private final KawaiiGuilds kawaiiGuilds;
    private String users = "SELECT * FROM `users`";
    private String guilds = "SELECT * FROM `guilds`";

    public MySQL(KawaiiGuilds kawaiiGuilds) {
        this.kawaiiGuilds = kawaiiGuilds;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + Config.MYSQL$HOST + ":"+ Config.MYSQL$PORT +"/" + Config.MYSQL$DATABASE);
        config.setUsername(Config.MYSQL$USER);
        String pass = Config.MYSQL$PASSWORD;
        config.setPassword(pass);

        source = new HikariDataSource(config);

        connect();
        Bukkit.getLogger().log(Level.INFO, "Polaczono z baza MySQL");
    }

    @Override
    protected Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    @Override
    public void connect() {
        try {
            getConnection();
            if(Config.USER_STORE.equalsIgnoreCase("mysql")) {
                checkUserTable();
            }
            if(Config.GUILD_STORE.equalsIgnoreCase("mysql")) {
                checkGuildTable();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(KawaiiGuilds.getProvidingPlugin(KawaiiGuilds.class));
        }
    }

    @Override
    public void disconnect() throws SQLException {
        saveUserData();
        saveGuildData();
        getConnection().close();
    }

    @Override
    public void checkUserTable() {
        String users = "CREATE TABLE IF NOT EXISTS users(`uuid` VARCHAR(36) NOT NULL, `name` VARCHAR(16) NOT NULL, `points` INT NOT NULL, `kills` INT NOT NULL, `deaths` INT NOT NULL, PRIMARY KEY(uuid));";
        try {
            this.getConnection().prepareStatement("SELECT * FROM users").executeUpdate(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkGuildTable() {
        String guilds = "CREATE TABLE IF NOT EXISTS guilds(`tag` VARCHAR(4) NOT NULL, `name` TEXT NOT NULL, PRIMARY KEY(tag));";
        try {
            this.getConnection().prepareStatement("SELECT * FROM 'guilds'").executeUpdate(guilds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUserData() throws SQLException {
        for (User user : kawaiiGuilds.getUserManager().getUsers()) {
            String users = "INSERT INTO users (uuid, name, points, kills, deaths) VALUES (" +
                    "'" + user.getUUID().toString() + "'," +
                    "'" + user.getName() + "'," +
                    "'" + user.getPoints() + "'," +
                    "'" + user.getKills() + "'," +
                    "'" + user.getDeaths() + "'" +
                    ") ON DUPLICATE KEY UPDATE " +
                    "name='" + user.getName() + "'," +
                    "points='" + user.getPoints() + "'," +
                    "kills='" + user.getKills() + "'," +
                    "deaths='" + user.getDeaths() + "';";
            this.getConnection().prepareStatement(this.users).executeUpdate(users);
        }
    }

    @Override
    public void saveGuildData() throws SQLException {
        for(Guild guild : kawaiiGuilds.getGuildManager().getGuilds()) {
            String guilds = "INSERT INTO guilds (tag, name) VALUES (" +
                    "'" + guild.getTag() + "'," +
                    "'" + guild.getName() + "'" +
                    ") ON DUPLICATE KEY UPDATE " +
                    "tag='" + guild.getTag() + "'," +
                    "name='" + guild.getName() + "';";
            this.getConnection().prepareStatement(this.guilds).executeUpdate(guilds);
        }
    }

    @Override
    public void loadUserData() throws SQLException {
        PreparedStatement ps = this.getConnection().prepareStatement(this.users);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            this.kawaiiGuilds.getUserManager().loadUsers(rs);
        }
        this.kawaiiGuilds.getLogger().log(Level.INFO, "Users loading: " + kawaiiGuilds.getUserManager().getUsers().size());
    }

    @Override
    public void loadGuildData() throws SQLException {
        PreparedStatement ps = this.getConnection().prepareStatement(this.guilds);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            this.kawaiiGuilds.getGuildManager().loadGuilds(rs);
        }
        this.kawaiiGuilds.getLogger().log(Level.INFO, "Guilds loading: " + this.kawaiiGuilds.getGuildManager().getGuilds().size());
    }


    @Override
    public void execute(String query) throws SQLException {
        PreparedStatement statement = source.getConnection().prepareStatement(query);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void query(String query, Callback<ResultSet> rs) throws Exception {
        PreparedStatement statement = source.getConnection().prepareStatement(query);
        rs.result(statement.executeQuery());
        statement.close();
    }
}
