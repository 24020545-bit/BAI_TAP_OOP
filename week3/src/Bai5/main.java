package Bai5;

import java.util.Scanner;

class Employee{
    private String name;
    private String birthDay;
    private String id;
    private String type;
    public Employee(String name){
        this.name=name;
    }
    public double getCalculateSalary(){
        return 0;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
}
class FullTimeEmployee extends Employee{
    private double baseSalary;
    private double bonus;
    private double penalty;
    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty){
        super(name);
        this.baseSalary=baseSalary;
        this.bonus=bonus;
        this.penalty=penalty;
        this.setType("Full-time");
    }
    @Override
    public double getCalculateSalary(){
        return baseSalary+bonus-penalty;
    }
}
class PartTimeEmployee extends Employee{
    private double workingHours;
    private double hourlyRate;
    public PartTimeEmployee(String name, double workingHours, double hourlyRate){
        super(name);
        this.hourlyRate=hourlyRate;
        this.workingHours=workingHours;
        this.setType("Part-time");
    }
    @Override
    public double getCalculateSalary(){
        return workingHours*hourlyRate;
    }
}

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Employee[] employees = new Employee[n];

        for(int i=0; i<n; i++){
            String line = scan.nextLine();

            String[] a = line.split("\"");

            String type = a[0].trim();
            String name = a[1];

            String[] data = a[2].trim().split(" ");

            if(type.equals("F")){
                double baseSalary = Double.parseDouble(data[0]);
                double bonus = Double.parseDouble(data[1]);
                double penalty = Double.parseDouble(data[2]);

                employees[i] = new FullTimeEmployee(
                        name, baseSalary, bonus, penalty
                );
            }else{
                double workingHours = Double.parseDouble(data[0]);
                double hourlyRate = Double.parseDouble(data[1]);

                employees[i] = new PartTimeEmployee(
                        name, workingHours, hourlyRate
                );
            }
        }
        for(Employee v:employees){
            System.out.println(v.getName()+" - "+v.getType()+" - "+v.getCalculateSalary());
        }
    }
}
