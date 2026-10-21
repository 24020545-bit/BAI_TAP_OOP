package bai1;

public class main {
    public static void useString() {
        String s = "";
        long start = System.currentTimeMillis();
        for( int i=1; i<1000000; i++){
            s += "Hello";
        }
        long end = System.currentTimeMillis();
        System.out.println("Thoi gian chay: "+(end-start)+" ms");

    }

    public static void useStringBuffer(){
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for( int i=1; i<100000; i++){
            sb.append("Hello ");
        }
        long end = System.currentTimeMillis();
        System.out.println("Thoi gian chay: "+(end-start)+" ms");
    }
    public static void contentAnalysis(){
        String text = "Java is interesting! I love Java. "
                + "Java is easy to learn? Yes, Java is useful.";
        int count = 0;
        for (int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            if(c == '.' || c == '?' || c == '!'){
                count++;
            }
        }
        System.out.println("So cau: "+count);
        String newText = text.replace("Java","Python");

        System.out.println("Cau cu: "+text);
        System.out.println("Cau moi: "+newText);
    }

    public static void main(String[] args) {
        useString();
        useStringBuffer();
        contentAnalysis();
    }
}
