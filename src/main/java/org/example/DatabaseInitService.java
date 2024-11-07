package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sql = Files.readString(Paths.get("sql/init_db.sql"));

            String[] sqlStatements = sql.split(";");

            for (String statement : sqlStatements) {
                if (!statement.trim().isEmpty()) {
                    try (PreparedStatement pstmt = connection.prepareStatement(statement.trim())) {
                        pstmt.execute();
                    }
                }
            }

            System.out.println("Database structure initialized.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
