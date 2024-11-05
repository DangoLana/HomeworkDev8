package org.example;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
@Data
public class YoungestEldestWorker {
    private int id;
    private String name;
    private LocalDate birthday;

    public YoungestEldestWorker(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
