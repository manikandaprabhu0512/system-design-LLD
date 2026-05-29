package Problems.PaymentGatewaySystem.system;

import java.util.Random;

public class RazorpayBankingSystem implements BankingSystem {
    private Random rand = new Random();

    @Override
    public boolean processPayment(double amount) {
        System.out.println("[BankingSystem-Razorpay] Processing payment of " + amount + "...");
        // Simulate 90% success
        int r = rand.nextInt(100);
        return r < 90;
    }
}
