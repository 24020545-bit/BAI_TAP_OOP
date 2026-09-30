import java.util.Scanner;

public class Solution{
    //bai4
    public static long fibonacci(long n){
        if(n<0) return -1;
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        long kq=0,k1=0,k2=1;
        for(int i=2; i<=n; i++){
            if(Long.MAX_VALUE-k2<k1){
                return Long.MAX_VALUE;
            }
            kq=k1+k2;
            k1=k2;
            k2=kq;
        }
        return kq;
    }
    //bai5
    public static int gcd(int a, int b){
        if(a==0||b==0) return 0;
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    //bai6
    public static boolean isPrime(int n){
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    //bai7
    public static int reverse(int a){
        long m=0;
        while(a!=0){
            int n=a%10;
            m=m*10+n;
            a=a/10;
        }
        if(Math.abs(m)>Integer.MAX_VALUE){
            return 0;
        }
        return (int)m;
    }
    //bai8
    public static boolean isPalindrome(int n){
        int a = reverse(n);
        return a==n;
    }
    //bai9
    public static int sumOfDigits(int n){
        int a=0;
        n=Math.abs(n);
        while (n!=0){
            a+=n%10;
            n=n/10;
        }
        return a;
    }
    //bai10
    public static int secondLargest(int[] arr){
         if(arr.length<2){
             return -1;
         }
         int one = arr[0];
         int second = Integer.MIN_VALUE;
         for(int i=0; i<arr.length; i++){
             if(arr[i]>one){
                 second = one;
                 one = arr[i];
             }else if(arr[i]>second && arr[i]!=one){
                 second = arr[i];
             }
         }
         return second;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("FIBONACCI");
        System.out.print("Nhap n: ");
        long n = scan.nextLong();
        System.out.println("F("+n+") = " + fibonacci(n));

        System.out.println("TIM UCLN");
        System.out.print("Nhap a, b: ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println("UCLN: "+gcd(a,b));

        System.out.println("SO NGUYEN TO ?");
        System.out.print("Nhap n: ");
        int m = scan.nextInt();
        if(isPrime(m)) {
            System.out.println(m + " la so nguyen to");
        }else{
            System.out.println(m+" khong la so nguyen to");
        }

        System.out.println("Dao nguoc so Va so Palindrome");
        System.out.print("Nhap k: ");
        int k = scan.nextInt();
        System.out.println("Dao cua "+k+" là: "+reverse(k));
        if(isPalindrome(k)){
            System.out.println(k+" la so Palindrome");
        }else{
            System.out.println(k+" khong la so Palindrome");
        }

        System.out.println("TONG CAC CHU SO");
        System.out.print("Nhap h: ");
        int h = scan.nextInt();
        System.out.println(h+" co tong cac chu so la: "+sumOfDigits(h));

        System.out.println("SO LON THU 2 TRONG MANG");
        System.out.print("So phan tu: ");
        int e = scan.nextInt();
        System.out.print("Nhap mang: ");
        int[] arr = new int[e];
        for(int i=0; i<e; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println("So lon thu 2 trong mang la: "+secondLargest(arr));
    }
}