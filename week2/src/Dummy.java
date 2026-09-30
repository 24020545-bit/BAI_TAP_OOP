public class Dummy {
    // number of Dummy objects
    static int counter = 0;
    int num = 0;
    static int count() {
        return counter;
    }
    private String name;
    public Dummy(String name) {
        counter++;
        this.name = name;
    }
    //main function to test Dummy class
    public static void main(String args[]) {
        System.out.println(Dummy.count());
        Dummy d1 = new Dummy ("First Dummy");
        System.out.println(d1.count());
        Dummy d2 = new Dummy ("Second Dummy");
        System.out.println(d1.count());
    }
}
