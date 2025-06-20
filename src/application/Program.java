package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter localDateFormartter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter yearMonthFormatter = DateTimeFormatter.ofPattern("MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = scanner.nextLine();
        Department department = new Department(departmentName);

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = scanner.nextLine();

        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(
            scanner.nextLine()
            .toUpperCase()
            .replace(" ", "_")
        );

        System.out.print("Base salary: ");
        Double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(workerName, workerLevel, baseSalary, department);

        System.out.print("How many contracts to this worker? ");
        int contractsValue = scanner.nextInt();

        for (int i = 0; i < contractsValue; i++) {
            scanner.nextLine();

            System.out.println("Enter contract #" + (i + 1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate contractDate = LocalDate.parse(scanner.next(), localDateFormartter);

            System.out.print("Value per hour: ");
            Double valuePerHour = scanner.nextDouble();

            System.out.print("Duration (hours): ");
            Integer hours = scanner.nextInt();

            worker.addContract(new HourContract(contractDate, valuePerHour, hours));
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        YearMonth incomeDate = YearMonth.parse(scanner.next(), yearMonthFormatter);

        System.out.println(worker);
        System.out.println("Income for " + yearMonthFormatter.format(incomeDate) + ": "
            + worker.income(incomeDate.getYear(), incomeDate.getMonthValue()));

        scanner.close();

    }
}
