package Bai2_6;

import java.util.Scanner;

class Transaction{
    private final String transactionld, timestamp;
    private final double amount;
    public Transaction(String transactionld, double amount, String timestamp){
        this.transactionld=transactionld;
        this.amount=amount;
        this.timestamp=timestamp;
    }
    public double getAmount(){
        return amount;
    }
    public void printTransaction(){
        System.out.println("Ma giao dich: "+transactionld+"\nSo tien: "+amount+"\nThoi gian: "+timestamp);
    }
}

class Account{
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int dem;
    public Account(String accountId, double balance){
        this.accountId=accountId;
        this.balance=balance;
        dem=0;
        this.history=new Transaction[100];
    }

    public void addTransaction(Transaction t){
        if(t.getAmount()<=balance){
            balance-=t.getAmount();
            history[dem++]=t;
        }else{
            System.out.println("So du khong du, so du con lai: "+balance);
        }
    }
    public Transaction[] getHistory(){
        Transaction[] a= new Transaction[dem];
        for(int i=0; i<dem; i++){
            a[i]=history[i];
        }
        return a;
    }
}
public class main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Account ac = new Account("0985059605",10000000);
        System.out.print("Nhap so tien muon rut: ");
        double tien1 = scan.nextDouble();
        Transaction t = new Transaction("T10",tien1,"3/10/2026");
        ac.addTransaction(t);
        System.out.print("Nhap so tien muon rut: ");
        double tien2 = scan.nextDouble();
        Transaction t1 = new Transaction("T11",tien2,"4/10/2026");
        ac.addTransaction(t1);
        //Hacker
        Transaction[] m=ac.getHistory();
        Transaction hack = new Transaction("T0",9999999,"5/10/2026");
        m[0]=hack;
        System.out.println("\nDU LIEU HACKER THAY DOI");
        m[0].printTransaction();
        System.out.println("\nDU LIEU THUC TE");
        Transaction[] k=ac.getHistory();
        k[0].printTransaction();
    }
}
