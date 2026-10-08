package Bai4;

class Animal{
    public void makeSound(){
        System.out.println("Animal sound");
    }
}
class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound(){
        System.out.println("Meows meows");
    }
}

class Duck extends Animal {

}
public class main {
    public static void main(String[] args){
//        Animal a = new Dog();
//        Cat c = (Cat)a;
//        c.makeSound();
        Animal a = new Dog();
        if(a instanceof Cat){
            Cat c = (Cat) a;
        }else{
            System.out.println("Day khong phai la meo");
        }
    }
}

