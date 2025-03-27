package me.timvinci.terrastorage.integration.sophisticatedstorageinmotion;

import me.timvinci.terrastorage.inventory.InventoryUtils;
import net.minecraft.world.entity.Entity;
import net.p3pp3rf1y.sophisticatedstorageinmotion.entity.IMovingStorageEntity;

public class StorageMotionAccessors {

    public static boolean isMotionEntity(Entity entity) {
        if (!InventoryUtils.sophisticatedStorageInMotionLoaded) {
            return false;
        }
        return entity instanceof IMovingStorageEntity;
    }

}
