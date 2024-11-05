package org.example;

import lombok.Data;

@Data
public class MaxProjectCountClient {
    private int clientId;
    private int projectCount;

    public MaxProjectCountClient(int clientId, int projectCount) {
        this.clientId = clientId;
        this.projectCount = projectCount;
    }

    public int getClientId() {
        return clientId;
    }

    public int getProjectCount() {
        return projectCount;
    }

    @Override
    public String toString() {
        return "Client ID: " + clientId + ", Project Count: " + projectCount;
    }
}

