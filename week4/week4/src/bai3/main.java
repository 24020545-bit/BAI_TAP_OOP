package bai3;

import java.util.Scanner;

abstract class Employee implements IWorkable{
    private String id;
    private String name;
    private double baseSalary;
    public Employee(String id, String name, double baseSalary){
        this.id=id;
        this.name=name;
        this.baseSalary=baseSalary;
    }
    abstract public double calculatePay();
    public double getBaseSalary(){
        return baseSalary;
    }

    public String getName() {
        return name;
    }
}
class OfficeWorker extends Employee{
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id,name,baseSalary);
    }

    @Override
    public double calculatePay(){
        return this.getBaseSalary();
    }
    @Override
    public void work(){
        System.out.println("Soan thao van ban");
    }
}
class Technician extends Employee{
    private int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours=overtimeHours;
    }

    @Override
    public double calculatePay(){
        return this.getBaseSalary()+overtimeHours*20000;
    }
    @Override
    public void work(){
        System.out.println("Lap dat thiet bi");
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double baseSalary = sc.nextDouble();

            if (type.equals("O")) {
                employees[i] = new OfficeWorker(id, name, baseSalary);
            } else if (type.equals("T")) {
                int overtimeHours = sc.nextInt();
                employees[i] = new Technician(id, name, baseSalary, overtimeHours);
            }
        }

        double totalPay = 0;

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - Pay: "
                    + employee.calculatePay());

            employee.work();

            totalPay += employee.calculatePay();

            System.out.println();
        }

        System.out.println("Total Pay = " + totalPay);

        sc.close();
    }
}
