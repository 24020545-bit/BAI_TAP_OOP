package Bai2_8;

public class Person {
    private String name;
    private Person me;
    public Person(String name){
        this.name=name;
    }
    public void setMe(Person other){
        me=other;
    }
    public Person getMe(){
        return me;
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args){
        Person p = new Person("Vu Van Kien");
        p.setMe(p);
        System.out.printf(p.me.getName());
        p=null;
    }
}
