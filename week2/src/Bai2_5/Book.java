package Bai2_5;

public class Book {
    private String title, author;
    private double price;
    public Book(String title, String author, double price){
        this.author=author;
        this.price=price;
        this.title=title;
    }
    // yeu cau de bai: ghi de ham Equals trong class Object cua Java
    @Override //bao cho java biet ta ghi de
    public boolean equals(Object obj){
        if(obj==null) return false;
        Book other = (Book) obj;
        return (title==other.title && author==other.author && price==other.price);
    }
    public static void main(String[] args){
        Book a1 = new Book("Conan","Aoyama",200000);
        Book a2 = new Book("Doraemon","Fujio",200000);
        Book a3 = new Book("Conan","Aoyama",200000);
        if(a1.equals(a2)){
            System.out.println("a1 giong a2");
        }else{
            System.out.println("a1 khac a2");
        }
        if(a1.equals(a3)){
            System.out.println("a1 giong a3");
        }else{
            System.out.println("a1 khac a3");
        }
    }
}
