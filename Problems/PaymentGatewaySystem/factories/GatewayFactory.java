package Problems.PaymentGatewaySystem.factories;

import Problems.PaymentGatewaySystem.enums.GatewayType;
import Problems.PaymentGatewaySystem.gateway.PaymentGateway;
import Problems.PaymentGatewaySystem.gateway.PaymentGatewayProxy;
import Problems.PaymentGatewaySystem.gateway.PaytmGateway;
import Problems.PaymentGatewaySystem.gateway.RazorpayGateway;

public class GatewayFactory {
    private static final GatewayFactory instance = new GatewayFactory();

    public static GatewayFactory getInstance() {
        return instance;
    }

    public PaymentGateway getGateway(GatewayType type) {
        if (type == GatewayType.PAYTM) {
            PaymentGateway paymentGateway = new PaytmGateway();
            return new PaymentGatewayProxy(paymentGateway, 3);
        } else {
            PaymentGateway paymentGateway = new RazorpayGateway();
            return new PaymentGatewayProxy(paymentGateway, 1);
        }
    }
}
