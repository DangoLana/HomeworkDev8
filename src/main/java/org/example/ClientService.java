package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private List<Client> clients = new ArrayList<>();
    public long create(String name) throws IllegalArgumentException {
        validateName(name);

        Client newClient = new Client(clients.size() + 1, name);
        clients.add(newClient);
        return newClient.getId();
    }

    public String getById(long id) throws IllegalArgumentException {
        Client client = findClientById(id);
        return client != null ? client.getName() : null;
    }

    public void setName(long id, String name) throws IllegalArgumentException {
        validateName(name);

        Client client = findClientById(id);
        if (client != null) {
            client.setName(name);
        } else {
            throw new IllegalArgumentException("Client not found with id: " + id);
        }
    }

    public void deleteById(long id) throws IllegalArgumentException {
        Client client = findClientById(id);
        if (client != null) {
            clients.remove(client);
        } else {
            throw new IllegalArgumentException("Client not found with id: " + id);
        }
    }

    public List<Client> listAll() {
        return new ArrayList<>(clients);
    }

    private void validateName(String name) {
        if (name == null || name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Client name must be between 2 and 1000 characters.");
        }
    }

    private Client findClientById(long id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}