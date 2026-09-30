import java.util.Scanner;

public class Student {
    private String id,name,email;
    private double gpa;

    public Student(){
        id="";
        name="";
        email="";
        gpa=0;
    }

    public Student(String id, String name){
        this.id=id;
        this.name=name;
        email="";
        gpa=0;
    }

    public Student(String id, String name, String email, double gpa){
        this.id=id;
        this.name=name;
        this.email=email;
        this.gpa=gpa;
    }

    public void setGpa(double gpa){
        if(gpa>=0 && gpa<=4){
            this.gpa=gpa;
            System.out.println("Nhap diem thanh cong");
        }else{
            System.out.println("Nhap diem khong hop le");
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Student hs1 = new Student();
        Student hs2 = new Student("24020545","Vu Van Kien");
        Student hs3 = new Student("24020545","Vu Van Kien","vuvankien2k6@gmail.com",3.5);
        System.out.print("Nhap gpa: ");
        double gpa1 = scan.nextDouble();
        hs2.setGpa(gpa1);
    }
}
