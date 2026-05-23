package Patterns.SingleTon_Pattern;

public class ThreadSafeLocking {
    private static ThreadSafeLocking instance = null;

    private ThreadSafeLocking() {
        System.out.println("SingleTon Constructor Called!");
    }

    public static ThreadSafeLocking getInstance() {
        synchronized(ThreadSafeLocking.class) {
            if(instance == null) {
                instance = new ThreadSafeLocking();
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeLocking t1 = ThreadSafeLocking.getInstance();
        ThreadSafeLocking t2 = ThreadSafeLocking.getInstance();

        System.out.println(t1 == t2);
    }
}
