package me.timvinci.terrastorage.integration.netherchest;

import fuzs.netherchested.world.level.block.entity.NetherChestBlockEntity;
import me.timvinci.terrastorage.inventory.InventoryUtils;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntity;

public class NetherChestAccessors {

    public static Container turnStorage(BlockEntity blockEntity) {
        if (!InventoryUtils.netherChestedLoaded) {
            return null;
        }
        if (blockEntity instanceof NetherChestBlockEntity netherChest) {
            if (((Object) netherChest.getContainer()) instanceof Container c) {
                return c;
            }
        }
        return null;
    }

    public static Integer getMaxStackSize(Container container, int slot) {
        if (InventoryUtils.netherChestedLoaded) {
            return container.getMaxStackSize(container.getItem(slot));
        }
        return null;
    }

}
