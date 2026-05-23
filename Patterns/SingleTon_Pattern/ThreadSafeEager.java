package Patterns.SingleTon_Pattern;

public class ThreadSafeEager {
    private static final ThreadSafeEager instance = new ThreadSafeEager();

    private ThreadSafeEager() {
        System.out.println("Constructor called...");
    }

    public static ThreadSafeEager getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeEager e1 = ThreadSafeEager.getInstance();
        ThreadSafeEager e2 = ThreadSafeEager.getInstance();

        System.out.println(e1 == e2);
    }
}
