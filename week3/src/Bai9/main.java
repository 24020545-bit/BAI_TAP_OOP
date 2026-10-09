package Bai9;

import java.util.Scanner;

abstract class Staff implements IPayable{
    private String id;
    private String name;
    public Staff(String id, String name){
        this.id=id;
        this.name=name;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPaymentAmount(){
        return 0;
    }
    public void printPay(){}
}
class PartTimeStaff extends Staff{
    private int workingHours;
    private double hourlyRate;
    private final String type="PartTimeStaff";
    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate){
        super(id,name);
        this.workingHours=workingHours;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double getPaymentAmount(){
        return workingHours*hourlyRate;
    }
    @Override
    public void printPay(){
        System.out.println("PartTimeStaff "+this.getName()+" - Payment: "+this.getPaymentAmount());
    }
}
class Invoice implements IPayable{
    private String itemName;
    private int quantity;
    private double pricePerItem;
    public Invoice(String itemName, int quantity, double pricePerItem){
        this.itemName=itemName;
        this.quantity=quantity;
        this.pricePerItem=pricePerItem;
    }
    @Override
    public double getPaymentAmount(){
        return quantity*pricePerItem;
    }

    @Override
    public void printPay(){
        System.out.println("Invoice "+itemName+" - Payment: "+this.getPaymentAmount());
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        IPayable[] payableList = new IPayable[n];
        for (int i = 0; i < n; i++) {
            String type = scan.next();

            if (type.equals("S")) {
                String id = scan.next();
                String name = scan.next();
                int workingHours = scan.nextInt();
                double hourlyRate = scan.nextDouble();

                payableList[i] = new PartTimeStaff(id, name, workingHours, hourlyRate);
            } else if (type.equals("I")) {
                String itemName = scan.next();
                int quantity = scan.nextInt();
                double pricePerItem = scan.nextDouble();

                payableList[i] = new Invoice(itemName, quantity, pricePerItem);
            }
        }

        double totalPayment = 0;

        for (IPayable payable : payableList) {
            payable.printPay();
            totalPayment += payable.getPaymentAmount();
        }

        System.out.println("Total Payment = " + totalPayment);

        scan.close();
    }
}
