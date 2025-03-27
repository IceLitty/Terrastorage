package me.timvinci.terrastorage.integration.sophisticatedcore;

import me.timvinci.terrastorage.inventory.InventoryUtils;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.p3pp3rf1y.sophisticatedcore.controller.IControllableStorage;
import net.p3pp3rf1y.sophisticatedcore.inventory.InventoryHandler;

public class StorageAccessors {

    /**
     * Used for sophisticated storage and backpack
     */
    public static Container turnStorage(BlockEntity blockEntity) {
        if (!InventoryUtils.sophisticatedCoreLoaded) {
            return null;
        }
        if (blockEntity instanceof IControllableStorage wrapper) {
            InventoryHandler inventoryHandler = wrapper.getStorageWrapper().getInventoryHandler();
            return new SophisticatedContainer(inventoryHandler);
        }
        return null;
    }

    public static Integer getMaxStackSize(Container container, int slot) {
        if (InventoryUtils.sophisticatedCoreLoaded && container instanceof SophisticatedContainer sophisticatedContainer) {
            return sophisticatedContainer.getInventoryHandler().getSlotLimit(slot);
        }
        return null;
    }

}
