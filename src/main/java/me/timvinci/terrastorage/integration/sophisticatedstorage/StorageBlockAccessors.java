package me.timvinci.terrastorage.integration.sophisticatedstorage;

import me.timvinci.terrastorage.inventory.InventoryUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.p3pp3rf1y.sophisticatedstorage.block.StorageBlockEntity;
import net.p3pp3rf1y.sophisticatedstorage.common.gui.StorageContainerMenu;

public class StorageBlockAccessors {

    public static BlockEntity getBlockEntity(AbstractContainerMenu menu) {
        if (!InventoryUtils.sophisticatedStorageLoaded) {
            return null;
        }
        if (menu instanceof StorageContainerMenu blockMenu) {
            return blockMenu.getStorageBlockEntity();
        }
        return null;
    }

    public static boolean setCustomName(BlockEntity blockEntity, Component newCustomName) {
        if (!InventoryUtils.sophisticatedStorageLoaded) {
            return false;
        }
        if (blockEntity instanceof StorageBlockEntity storageBlockEntity) {
            storageBlockEntity.setCustomName(newCustomName);
            return true;
        }
        return false;
    }

}
