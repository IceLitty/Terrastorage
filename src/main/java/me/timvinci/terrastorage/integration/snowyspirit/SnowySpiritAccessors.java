package me.timvinci.terrastorage.integration.snowyspirit;

import me.timvinci.terrastorage.inventory.InventoryUtils;
import net.mehvahdjukaar.snowyspirit.common.entity.ContainerHolderEntity;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;

public class SnowySpiritAccessors {

    public static Container turnStorage(Entity entity) {
        if (!InventoryUtils.snowySpiritLoaded) {
            return null;
        }
        if (entity instanceof ContainerHolderEntity sledEntity) {
            return sledEntity;
        }
        return null;
    }

    public static Integer getMaxStackSize(Container container, int slot) {
        return null;
    }

}
