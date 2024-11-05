package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        List<MaxProjectCountClient> maxProjectCountClients = queryService.findMaxProjectsClient();
        System.out.println("Max Projects Clients: " + maxProjectCountClients);

        List<LongestProject> longestProjects = queryService.findLongestProject();
        System.out.println("Longest Projects: " + longestProjects);

        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        System.out.println("Max Salary Worker: " + maxSalaryWorkers);

        List<YoungestEldestWorker> youngestEldestWorkers = queryService.findYoungestEldestWorker();
        System.out.println("Youngest And Eldest Workers: " + youngestEldestWorkers);
    }
}