package orders;

import customer.Customer;     
import cart.ShoppingCart;
import payment.PaymentMethod; 

public class Order {

    private static int counter = 1000;

    private String orderId;
    private Customer customer;
    private double finalAmount;

    public Order(Customer customer, ShoppingCart cart) {
        this.orderId = "ORD" + counter++;
        this.customer = customer;
        this.finalAmount = cart.getTotalAmount() * 1.18;
    }

    public void placeOrder(PaymentMethod payment) {
        if (payment.pay(finalAmount)) {
            System.out.println("Order ID: " + orderId);
            customer.displayCustomer();
            System.out.println("Final Amount (incl GST): ₹" + finalAmount);
            System.out.println("Order Placed Successfully!");
        }
    }

    
    public void displayOrderSummary() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Final Amount: ₹" + finalAmount);
    }
}
