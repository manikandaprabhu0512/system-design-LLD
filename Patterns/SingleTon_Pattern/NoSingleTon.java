package Patterns.SingleTon_Pattern;

public class NoSingleTon {
    public NoSingleTon() {
        System.out.println("SingleTon Instruction Called. New Instance is Created.");
    }

    public static void main(String[] args) {
        NoSingleTon noSingleTon1 = new NoSingleTon();
        NoSingleTon noSingleTon2 = new NoSingleTon();

        System.out.println(noSingleTon1 == noSingleTon2);
    }
}