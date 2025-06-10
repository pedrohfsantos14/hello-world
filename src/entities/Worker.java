package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        LocalDate incomeDate = LocalDate.of(year, month, 30);

        List<HourContract> newList = contracts.stream()
                .filter(contracts -> contracts.getDate().isEqual(incomeDate))
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
