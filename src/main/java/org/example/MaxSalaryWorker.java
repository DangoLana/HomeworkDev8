package org.example;

import lombok.Data;

@Data
public class MaxSalaryWorker {
    private int workerId;
    private String name;
    private int salary;

    public MaxSalaryWorker(int workerId, String name, int salary) {
        this.workerId = workerId;
        this.name = name;
        this.salary = salary;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "workerId=" + workerId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}