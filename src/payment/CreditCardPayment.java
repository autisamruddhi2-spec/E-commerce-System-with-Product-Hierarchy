package payment;


public class CreditCardPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
        return true;
    }
}
