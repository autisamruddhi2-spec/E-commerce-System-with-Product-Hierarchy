package cart;

import java.util.*;
import products.Product;

public class ShoppingCart {

    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {

        if (product.getStockQuantity() < quantity) {
            System.out.println("Not enough stock!");
            return;
        }

        for (CartItem item : items) {
            if (item.getProduct().getId().equalsIgnoreCase(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                product.reduceStock(quantity);
                System.out.println("Quantity updated in cart.");
                return;
            }
        }

        items.add(new CartItem(product, quantity));
        product.reduceStock(quantity);
        System.out.println("Added to cart!");
    }

    public void removeProduct(String productId) {
        items.removeIf(item ->
                item.getProduct().getId().equalsIgnoreCase(productId));
        System.out.println("Product removed from cart.");
    }

    public void updateQuantity(String productId, int newQty) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equalsIgnoreCase(productId)) {
                item.setQuantity(newQty);
                System.out.println("Quantity updated.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : items)
            total += item.getTotal();
        return total;
    }

    public void displayCart() {

        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\n===== YOUR CART =====");

        for (CartItem item : items) {
            System.out.println(
                    item.getProduct().getId() + " | " +
                    item.getProduct().getName() +
                    " x " + item.getQuantity() +
                    " = ₹" + item.getTotal()
            );
        }

        double subtotal = getTotalAmount();
        double gst = subtotal * 0.18;
        double finalAmount = subtotal + gst;

        System.out.println("-----------------------------");
        System.out.println("Subtotal: ₹" + subtotal);
        System.out.println("GST (18%): ₹" + gst);
        System.out.println("Total with GST: ₹" + finalAmount);
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
