package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String sqlFilePath = "sql/populate_db.sql";

        String sqlStatements;
        try {
            sqlStatements = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
            return;
        }

        try (Connection connection = Database.getConnection()) {

            String[] sqlArray = sqlStatements.split(";");
            for (String sql : sqlArray) {
                if (!sql.trim().isEmpty()) {
                    try (PreparedStatement pstmt = connection.prepareStatement(sql.trim())) {
                        pstmt.execute();

                        if (sql.trim().toUpperCase().startsWith("CREATE TABLE")) {
                            String tableName = sql.trim().split(" ")[2];
                            System.out.println("Таблиця '" + tableName + "' була успішно створена.");
                        }
                    }
                }
            }

            System.out.println("The database tables have been successfully populated.");

        } catch (SQLException e) {
            System.err.println("Error populating database: " + e.getMessage());
        }
    }
}

