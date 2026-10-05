package Bai2_9;

import java.util.Scanner;

public class Product {
    private String name;
    private double price, discount;
    private int quantity;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;
    public Product(String name, double price, int quantity, double discount){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.discount=discount;
    }
    public static void updateTaxRate(double newRate){
        taxRate=newRate;
    }
    public double calculateFinalPrice(){
        //finalPrice = (price-discount)*(1+taxRate)
        return (price-discount)*(1+taxRate);
    }
    public void updateDiscount(double newDiscount){
        discount=newDiscount;
    }
    public void sell(int amount){
        if(amount<=quantity){
            quantity-=amount;
            totalRevenue+=this.calculateFinalPrice()*amount;
            System.out.println("Thanh cong");
        }else{
            System.out.println("Khong du hang trong kho");
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap thong tin san pham (Product)");
        System.out.println("\nPRODUCT 1");
        System.out.print("Name: ");
        String name1 = scan.next();
        System.out.print("Gia ban: ");
        double price1 = scan.nextDouble();
        System.out.print("Ton kho: ");
        int quantity1 = scan.nextInt();
        System.out.print("Giam gia: ");
        double discount1 = scan.nextDouble();
        Product p1 = new Product(name1,price1,quantity1,discount1);

        System.out.println("\nPRODUCT 2");
        System.out.print("Name: ");
        String name2 = scan.next();
        System.out.print("Gia ban: ");
        double price2 = scan.nextDouble();
        System.out.print("Ton kho: ");
        int quantity2 = scan.nextInt();
        System.out.print("Giam gia: ");
        double discount2 = scan.nextDouble();
        Product p2 = new Product(name2,price2,quantity2,discount2);

        System.out.print("So luong can mua San pham p1: ");
        int amount1 = scan.nextInt();
        p1.sell(amount1);
        System.out.print("So luong can mua San pham p2: ");
        int amount2 = scan.nextInt();
        p2.sell(amount2);

        System.out.println("Giai cuoi cung p1: "+p1.calculateFinalPrice());
        System.out.println("Giai cuoi cung p2: "+p2.calculateFinalPrice());

        System.out.println("\nSAU KHI GIAM THUE");
        Product.updateTaxRate(0.08);
        System.out.println("Giai cuoi cung p1: "+p1.calculateFinalPrice());
        System.out.println("Giai cuoi cung p2: "+p2.calculateFinalPrice());

        System.out.println("\nTHAY DOI MUC GIAM SAN PHAM p1 BANG 10");
        p1.updateDiscount(10);
        System.out.println("Giai cuoi cung p1: "+p1.calculateFinalPrice());
        System.out.println("Giai cuoi cung p2: "+p2.calculateFinalPrice());

        System.out.println("Tong doanh thu toan he thong: "+Product.totalRevenue);
    }
}