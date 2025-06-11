package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract (HourContract contract) {
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        this.contracts.remove(contract);
    }

    public Double income(Integer year, Integer month) {
        List<HourContract> newList = contracts.stream()
            .filter(contract ->
                contract.getDate().getYear() == year &&
                contract.getDate().getMonthValue() == month
            )
            .toList();

        Double incomeSum = baseSalary;
        for (HourContract contract : newList) {
            incomeSum += contract.totalValue();
        }

        return incomeSum;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDepartment: " + this.department.getName();
    }
}
