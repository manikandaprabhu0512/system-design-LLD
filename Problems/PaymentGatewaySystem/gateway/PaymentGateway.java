package Problems.PaymentGatewaySystem.gateway;

import Problems.PaymentGatewaySystem.dto.PaymentRequest;
import Problems.PaymentGatewaySystem.system.BankingSystem;

public abstract class PaymentGateway {
    protected BankingSystem bankingSystem;

    public PaymentGateway() {
        this.bankingSystem = null;
    }

    public boolean processPayment(PaymentRequest request) {
        if (!validatePayment(request)) {
            System.out.println("[PaymentGateway] Validation failed for " + request.sender + ".");
            return false;
        }
        if (!initiatePayment(request)) {
            System.out.println("[PaymentGateway] Initiation failed for " + request.sender + ".");
            return false;
        }
        if (!confirmPayment(request)) {
            System.out.println("[PaymentGateway] Confirmation failed for " + request.sender + ".");
            return false;
        }
        return true;
    }

    protected abstract boolean validatePayment(PaymentRequest request);
    protected abstract boolean initiatePayment(PaymentRequest request);
    protected abstract boolean confirmPayment(PaymentRequest request);
}
