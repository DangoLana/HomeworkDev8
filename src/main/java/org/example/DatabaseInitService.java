package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sql = Files.readString(Paths.get("sql/init_db.sql"));

            try (Statement stmt = connection.createStatement()) {
                stmt.execute(sql);
                System.out.println("Database structure initialized.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
