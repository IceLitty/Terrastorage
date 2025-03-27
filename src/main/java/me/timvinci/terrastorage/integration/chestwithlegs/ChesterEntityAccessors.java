package me.timvinci.terrastorage.integration.chestwithlegs;

import me.timvinci.terrastorage.inventory.InventoryUtils;
import net.mcreator.chestwithlegs.entity.ChesterEntity;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;

public class ChesterEntityAccessors {

    public static Container turnStorage(Entity entity) {
        if (!InventoryUtils.sophisticatedCoreLoaded) {
            return null;
        }
        if (entity instanceof ChesterEntity chester) {
            CombinedInvWrapper inventory = chester.getInventory();
            return new ChesterEntityContainer(inventory);
        }
        return null;
    }

    public static Integer getMaxStackSize(Container container, int slot) {
        return null;
    }

}
