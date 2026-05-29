package Problems.PaymentGatewaySystem.dto;

public class PaymentRequest {
    public String sender;
    public String reciever;
    public double amount;
    public String currency;

    public PaymentRequest(String sender, String reciever, double amt, String curr) {
        this.sender   = sender;
        this.reciever = reciever;
        this.amount   = amt;
        this.currency = curr;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    
}
