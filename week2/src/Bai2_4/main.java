package Bai2_4;

class MyDate {
    private int day, month, year;
    public MyDate(int d, int m, int y){
        day=d;
        month=m;
        year=y;
    }
    public MyDate(MyDate a){
        this.day=a.day;
        this.month=a.month;
        this.year=a.year;
    }
    public void printMyDate(){
        System.out.println(day+"/"+month+"/"+year);
    }
}

class Employee{
    private String name;
    private MyDate birthday;
    public Employee(String name, MyDate birthday){
        this.name=name;
        this.birthday=birthday;
    }
    public Employee(Employee a){
        this.name=a.name;
        this.birthday=new MyDate(a.birthday);
    }
    public MyDate getBirthday(){
        return this.birthday;
    }
}
public class main{
    public static void main(String[] args){
        MyDate date = new MyDate(21,4,2006);
        Employee emp1 = new Employee("Vu Van Kien", date);
        Employee emp2 = new Employee(emp1);
        System.out.print("Ngay sinh emp2: ");
        MyDate date2 = emp2.getBirthday();
        date2.printMyDate();
    }
}
