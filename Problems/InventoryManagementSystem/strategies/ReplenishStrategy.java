package Problems.InventoryManagementSystem.strategies;

import java.util.Map;

import Problems.InventoryManagementSystem.managers.InventoryManager;

public interface ReplenishStrategy {
    void replenish(InventoryManager manager, Map<Integer,Integer> itemsToReplenish);
}
