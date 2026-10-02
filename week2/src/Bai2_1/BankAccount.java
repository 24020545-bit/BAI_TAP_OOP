import java.util.Scanner;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName){
        this.accountNumber=accountNumber;
        this.balance=0;
        this.ownerName=ownerName;
    }

    public BankAccount(String accountNumber, String ownerName, double balance){
        this.accountNumber=accountNumber;
        this.ownerName=ownerName;
        if(balance<0){
            this.balance=0;
            System.out.println("So du khong duoc am");
        }else{
            this.balance=balance;
        }
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Nap tien thanh cong: "+amount);
        }else{
            System.out.println("Loi: So tien phai>0");
        }
    }

    public boolean withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            return true;
        }
        return false;
    }

    public double getBalance(){
        return balance;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        BankAccount tk1 = new BankAccount("0985059604","VU VAN KIEN");
        System.out.print("Nhap so tien de nap vao: ");
        double nap1 = scan.nextDouble();
        tk1.deposit(nap1);
        System.out.println("So du tk1 la: "+tk1.getBalance());

        System.out.println("    RUT TIEN");
        System.out.print("Nhap so tien can rut: ");
        double rut1 = scan.nextDouble();
        if(tk1.withdraw(rut1)){
            System.out.println("Rut thanh cong, so du: "+tk1.getBalance());
        }else{
            System.out.println("Rut that bai, so du: "+tk1.getBalance());
        }
    }
}
