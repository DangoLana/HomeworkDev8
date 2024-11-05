package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sql = readSqlFile("sql/find_max_projects_client.sql");
        List<MaxProjectCountClient> result = new ArrayList<>();

        if (sql == null || sql.isEmpty()) {
            System.err.println("SQL file is empty or not found.");
            return result;
        }

        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int clientId = rs.getInt("CLIENT_ID");
                int projectCount = rs.getInt("PROJECT_COUNT");
                result.add(new MaxProjectCountClient(clientId, projectCount));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching max projects client: " + e.getMessage());
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        String sql = readSqlFile("sql/find_longest_project.sql");
        List<LongestProject> result = new ArrayList<>();

        if (sql == null || sql.isEmpty()) {
            System.err.println("SQL file is empty or not found.");
            return result;
        }

        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                int clientId = rs.getInt("CLIENT_ID");
                LocalDate startDate = rs.getDate("START_DATE").toLocalDate();
                LocalDate finishDate = rs.getDate("FINISH_DATE").toLocalDate();
                result.add(new LongestProject(id, clientId, startDate, finishDate));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching longest project: " + e.getMessage());
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sql = readSqlFile("sql/find_max_salary_worker.sql");
        List<MaxSalaryWorker> result = new ArrayList<>();

        if (sql == null || sql.isEmpty()) {
            System.err.println("SQL file is empty or not found.");
            return result;
        }

        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int workerId = rs.getInt("ID");
                String name = rs.getString("NAME");
                int salary = rs.getInt("SALARY");
                result.add(new MaxSalaryWorker(workerId, name, salary));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching max salary worker: " + e.getMessage());
        }
        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() {
        String sql = readSqlFile("sql/find_youngest_eldest_workers.sql");
        List<YoungestEldestWorker> result = new ArrayList<>();

        if (sql == null || sql.isEmpty()) {
            System.err.println("SQL file is empty or not found.");
            return result;
        }

        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                LocalDate birthday = rs.getDate("BIRTHDAY").toLocalDate();
                result.add(new YoungestEldestWorker(id, name, birthday));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching youngest and eldest workers: " + e.getMessage());
        }
        return result;
    }

        private String readSqlFile(String filePath) {
            StringBuilder sql = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sql.append(line).append(" ");
                }
            } catch (IOException e) {
                System.err.println("Error reading SQL file: " + e.getMessage());
            }

            return sql.toString().trim();
        }

}
