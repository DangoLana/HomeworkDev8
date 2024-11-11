package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        try {
            long clientId = clientService.create("Client1");
            System.out.println("Created client with ID: " + clientId);

            String clientName = clientService.getById(clientId);
            System.out.println("Client name: " + clientName);

            clientService.setName(clientId, "UpdatedClient");
            System.out.println("Updated client name: " + clientService.getById(clientId));

            List<Client> clients = clientService.listAll();
            System.out.println("All clients: " + clients);

            clientService.deleteById(clientId);
            System.out.println("Client with ID " + clientId + " deleted.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}