package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormartter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = scanner.nextLine();
        Department department = new Department(departmentName);

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = scanner.nextLine();

        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(scanner.nextLine()
                .toUpperCase()
                .replace(" ", "_"));

        System.out.print("Base salary: ");
        Double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(workerName, workerLevel, baseSalary, department);

        System.out.print("How many contracts to this worker? ");
        int contractsValue = scanner.nextInt();

        HourContract hourContract;
        for (int i = 0; i < contractsValue; i++) {
            scanner.nextLine();

            System.out.println("Enter contract #" + (i + 1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            String contractDateString = scanner.next();
            LocalDate contractDate = LocalDate.parse(contractDateString, dateFormartter);

            System.out.print("Value per hour: ");
            Double valuePerHour = scanner.nextDouble();

            System.out.print("Duration (hours): ");
            Integer hours = scanner.nextInt();

            hourContract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(hourContract);
        }

        System.out.print("Enter month and year to calculate income (DD/MM/YYYY): ");
        String incomeDateString = scanner.next();
        LocalDate incomeDate = LocalDate.parse(incomeDateString, dateFormartter);

        System.out.println(worker);
        System.out.println("Income for " + incomeDateString + ": "
                + worker.income(incomeDate.getYear(), incomeDate.getMonthValue()));

        scanner.close();
    }
}
