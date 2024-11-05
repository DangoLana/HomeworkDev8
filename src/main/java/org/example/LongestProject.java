package org.example;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
@Data
public class LongestProject {
    private int id;
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;

    public LongestProject(int id, int clientId, LocalDate startDate, LocalDate finishDate) {
        this.id = id;
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
