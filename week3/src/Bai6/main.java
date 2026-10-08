package Bai6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

class Product{
    private static int id = 0;
    private String name;
    private double finalPrice;
    private String type;

    public Product(String name, double finalPice) {
        id++;
        this.name = name;
        this.finalPrice = finalPice;
    }

    public double getFinalPice() {
        return finalPrice;
    }

    public double getPrice() {
        return finalPrice;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}

class Electronics extends Product {
    private final double VAT = 0.1;
    private double price = 0;

    public Electronics(String name, double finalPrice, double price) {
        super(name, finalPrice);
        this.price = price;
        this.setType("Electronics");
    }

    @Override
    public double getPrice() {
        return this.getFinalPice() + this.getFinalPice()*VAT + price;
    }
}

class Food extends Product {
    private LocalDate time;

    Food(String name, double finalPrice, LocalDate time) {
        super(name, finalPrice);
        this.time = time;
        this.setType("Food");
    }

    @Override
    public double getPrice() {
        long days = ChronoUnit.DAYS.between(time, LocalDate.now());

        if (days < 7) {
            return this.getFinalPice()*0.8;
        }
        return this.getFinalPice();
    }

}

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        Product[] products = new Product[n];
        double totalPrice = 0;

        for(int i = 0; i < n; i++){
            String line = scan.nextLine();

            String[] a = line.split("\"");

            String type = a[0].trim();
            String name = a[1];

            String[] data = a[2].trim().split(" ");

            if(type.equals("F")){
                double finalPrice = Double.parseDouble(data[0]);
                LocalDate time = LocalDate.parse(data[1]);

                products[i] = new Food(
                        name, finalPrice, time
                );
            }else{
                double finalPrice = Double.parseDouble(data[0]);
                double price = Double.parseDouble(data[1]);

                products[i] = new Electronics(
                        name, finalPrice, price
                );
            }
        }

        for(Product p : products){
            System.out.println(
                    p.getName() + " - " +
                            p.getType() + " - " +
                            p.getPrice()
            );
            totalPrice += p.getPrice();
        }
        System.out.println("Total = " + totalPrice);
    }
}
