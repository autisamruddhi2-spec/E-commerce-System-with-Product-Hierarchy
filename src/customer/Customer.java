package customer;

public class Customer {

    private String id;
    private String name;
    private String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String getName() {
    return name;
}
    public void displayCustomer() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
