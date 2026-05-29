package Problems.PaymentGatewaySystem.controller;

import Problems.PaymentGatewaySystem.dto.PaymentRequest;
import Problems.PaymentGatewaySystem.enums.GatewayType;
import Problems.PaymentGatewaySystem.factories.GatewayFactory;
import Problems.PaymentGatewaySystem.gateway.PaymentGateway;
import Problems.PaymentGatewaySystem.services.PaymentService;

public class PaymentController {
    private static final PaymentController instance = new PaymentController();

    public static PaymentController getInstance() {
        return instance;
    }

    public boolean handlePayment(GatewayType type, PaymentRequest req) {
        PaymentGateway paymentGateway = GatewayFactory.getInstance().getGateway(type);
        PaymentService.getInstance().setGateway(paymentGateway);
        return PaymentService.getInstance().processPayment(req);
    }
}
