package Problems.PaymentGatewaySystem.system;

import java.util.Random;

public class PaytmBankingSystem implements BankingSystem {
    private Random rand = new Random();

    @Override
    public boolean processPayment(double amount) {
        // Simulate 20% success
        int r = rand.nextInt(100);
        return r < 80;
    }
}
