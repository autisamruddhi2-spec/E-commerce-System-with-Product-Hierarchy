package orders;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayAllOrders() {

        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }

        System.out.println("\n===== ORDER HISTORY =====");

        for (Order order : orders) {
            order.displayOrderSummary();
            System.out.println("----------------------------");
        }
    }
}
