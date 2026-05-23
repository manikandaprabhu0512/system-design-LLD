package Problems.FoodDeliveryApp.strategies;

public class CardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Dollar:" + amount + "through Card (" + cardNumber + ")");
    }
    
}
