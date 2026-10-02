package Bai2_3;

public class NumberWrapper {
    private int value;
    public NumberWrapper(int n){
        value = n;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int n){
        value=n;
    }
    public static void swap(NumberWrapper a, NumberWrapper b){
        int c=a.value;
        a.value=b.value;
        b.value=c;
    }
    public static void main(String[] args){
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);
        swap(n1, n2);
        System.out.println("n1 = " + n1.getValue());
        System.out.println("n2 = " + n2.getValue());
    }
}
