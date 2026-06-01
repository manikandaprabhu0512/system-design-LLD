package Problems.InventoryManagementSystem;

import Problems.InventoryManagementSystem.core.Cart;
import Problems.InventoryManagementSystem.helper.InventoryHelper;
import Problems.InventoryManagementSystem.managers.OrderManager;
import Problems.InventoryManagementSystem.models.User;

public class Main {
    public static void main(String[] args) {
        InventoryHelper.initialize();

        User user = new User("Aditya", 1.0, 1.0);
        System.out.println("\nUser with name " + user.name + " comes on platform");

        InventoryHelper.showAllItems(user);

        System.out.println("\nAdding items to cart");
        Cart cart = user.getCart();
        cart.addItem(101, 4);
        cart.addItem(102, 3);
        cart.addItem(103, 2);

        OrderManager.getInstance().placeOrder(user, cart);
    }
}
