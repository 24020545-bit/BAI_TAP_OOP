package Bai2_7;

class Product{
    private String id,name;
    private double price;
    public Product(String id, String name, double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void printProduct(){
        System.out.println("Id: "+id+"; Name: "+name+"; Price: "+price);
    }
}
class Inventory{
    private Product[] items;
    //Day la sao chep vào mang items
//    public Inventory(Product[] initialltems){
//        items = new Product[initialltems.length];
//        for(int i=0; i<initialltems.length; i++){
//            items[i]=initialltems[i];
//        }
//    }
    //items duoc tro toi vung nho ma initialltems dang tro toi
    public Inventory(Product[] initialltems){
        items = initialltems;
    }
    public void printInventory(){
        for(int i=0; i<items.length; i++){
            items[i].printProduct();
        }
    }
}
public class main {
    public static void main(String[] args) {
        Product[] arr = new Product[2];
        arr[0] = new Product("P01", "Laptop", 15000000);
        arr[1] = new Product("A01", "Loa", 1500000);
        Inventory kho = new Inventory(arr);
        arr[0].setPrice(5000);
        kho.printInventory();
    }
}
