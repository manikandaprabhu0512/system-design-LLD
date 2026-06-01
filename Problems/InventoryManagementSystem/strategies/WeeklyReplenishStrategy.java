package Problems.InventoryManagementSystem.strategies;

import java.util.Map;

import Problems.InventoryManagementSystem.managers.InventoryManager;

public class WeeklyReplenishStrategy implements ReplenishStrategy {

    @Override
    public void replenish(InventoryManager manager, Map<Integer,Integer> itemsToReplenish) {
        System.out.println("[WeeklyReplenish] Weekly replenishment triggered for inventory.");
    }
}
