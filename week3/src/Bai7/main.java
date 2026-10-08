package Bai7;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

class HottelManage{
    private String name;
    private String type;
    public double getPrice(int days){
        return 0;
    }
    public void setType(){
        this.type=type;
    }
}

class Standard extends HottelManage{
    private final double finalPrice = 500000;

    @Override
    public double getPrice(int days){
        if(days>3){
            return finalPrice*0.95*days;
        }
        return finalPrice*days;
    }
}

class VIP extends HottelManage{
    private final double finalPrice = 2000000;

    @Override
    public double getPrice(int days){
        return finalPrice*days;
    }
}

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String type = scan.next();
        int days = scan.nextInt();
        HottelManage room;
        if(type.equals("S")){
            room = new Standard();
            System.out.println(room.getPrice(days));
        }else{
            room = new VIP();
            System.out.println(room.getPrice(days));
        }
    }
}
