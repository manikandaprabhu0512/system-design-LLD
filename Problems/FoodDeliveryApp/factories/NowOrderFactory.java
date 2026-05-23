package Problems.FoodDeliveryApp.factories;

import java.util.List;

import Problems.FoodDeliveryApp.models.Cart;
import Problems.FoodDeliveryApp.models.DeliveryOrder;
import Problems.FoodDeliveryApp.models.MenuItem;
import Problems.FoodDeliveryApp.models.Order;
import Problems.FoodDeliveryApp.models.PickupOrder;
import Problems.FoodDeliveryApp.models.Restaurant;
import Problems.FoodDeliveryApp.models.User;
import Problems.FoodDeliveryApp.strategies.PaymentStrategy;
import Problems.FoodDeliveryApp.utils.TimeUtils;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                             PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }
}
