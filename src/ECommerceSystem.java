import products.*;
import cart.*;
import customer.*;   
import orders.*;
import payment.*;    

import java.util.*;

public class ECommerceSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        products.add(new ElectronicsProduct("E1", "Smartphone",
                50000, "Latest Phone", 10,
                "Samsung", 24));

        products.add(new ClothingProduct("C1", "T-Shirt",
                1200, "Cotton T-Shirt", 50,
                "M", "Blue"));

        products.add(new BookProduct("B1", "Java Programming",
                800, "Learn Java", 30,
                "John Doe", "ISBN123"));

        ShoppingCart cart = new ShoppingCart();
        Customer customer = new Customer("CUST1", "Rahul", "rahul@email.com");
        OrderManager orderManager = new OrderManager();

        while (true) {

            System.out.println("\n1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Update Cart");
            System.out.println("5. Checkout");
            System.out.println("6. View Order History");
            System.out.println("7. Exit");


            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Product p : products)
                        p.displayInfo();
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    String id = sc.next();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    boolean found = false;

                    for (Product p : products) {
                        if (p.getId().equalsIgnoreCase(id)) {
                            cart.addProduct(p, qty);
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Product not found!");

                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:

                if (cart.isEmpty()) {
                    System.out.println("Cart is empty!");
                    break;
                }

                System.out.println("1. Update Quantity");
                System.out.println("2. Remove Item");

                int cartChoice = sc.nextInt();

                System.out.print("Enter Product ID: ");
                String cartId = sc.next();

                if (cartChoice == 1) {
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    cart.updateQuantity(cartId, newQty);
                } else if (cartChoice == 2) {
                    cart.removeProduct(cartId);
                }

    break;

                
                case 5:

                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty!");
                        break;
                    }

                    Order order = new Order(customer, cart);

                    System.out.println("1. Credit Card");
                    System.out.println("2. UPI");
                    int payChoice = sc.nextInt();

                    PaymentMethod payment;

                    if (payChoice == 1)
                        payment = new CreditCardPayment();
                    else
                        payment = new UpiPayment();

                    order.placeOrder(payment);

                    orderManager.addOrder(order);

                    cart.clearCart();

                    System.out.println("Cart cleared after checkout.");

                    break;

                case 6:
                    orderManager.displayAllOrders();
                    break;

                case 7:
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
