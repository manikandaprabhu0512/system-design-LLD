package Patterns.SingleTon_Pattern;

public class SimpleSingleTon {
    private static SimpleSingleTon simpleSingleTon = null;

    private SimpleSingleTon() {
        System.out.println("SingleTon Constructor Called...");
    }

    public static SimpleSingleTon createInstance() {
        if(simpleSingleTon == null) {
            simpleSingleTon = new SimpleSingleTon();
        }

        return simpleSingleTon;
    }

    public static void main(String[] args) {
        SimpleSingleTon s1 = SimpleSingleTon.createInstance();
        SimpleSingleTon s2 = SimpleSingleTon.createInstance();

        System.out.println(s1 == s2);
    }
}
