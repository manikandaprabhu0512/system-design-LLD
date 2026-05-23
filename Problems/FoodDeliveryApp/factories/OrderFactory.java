package Problems.FoodDeliveryApp.factories;

import java.util.List;

import Problems.FoodDeliveryApp.models.*;
import Problems.FoodDeliveryApp.strategies.PaymentStrategy;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
