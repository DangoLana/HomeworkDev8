package org.example;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = "jdbc:h2:~/test;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static Database instance;
    private Connection connection;

    private Database() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        Flyway flyway = Flyway.configure()
                .dataSource(DB_URL, USER, PASSWORD)
                .locations("db/migrations")
                .load();
        flyway.migrate();
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}