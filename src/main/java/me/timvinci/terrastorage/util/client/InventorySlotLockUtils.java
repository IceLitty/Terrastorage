package me.timvinci.terrastorage.util.client;

import me.timvinci.terrastorage.Terrastorage;
import me.timvinci.terrastorage.inventory.InventoryUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.anti_ad.mc.ipn.api.access.IPN;

import java.util.List;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class InventorySlotLockUtils {

    public static Optional<List<Integer>> getCurrentSlotsLocked() {
//        LocalPlayer localPlayer = Minecraft.getInstance().player;
//        if (localPlayer == null) {
//            Terrastorage.LOGGER.debug("Get player is null when trying to get locked slots in client side!!!");
//            return Optional.empty();
//        }
//        Inventory playerInventory = localPlayer.getInventory();
        if (InventoryUtils.inventoryProfilesNextLoaded) {
            try {
                return Optional.of(IPN.getInstance().getLockedSlots());
            } catch (Throwable e) {
                Terrastorage.LOGGER.debug("Failed to check this ItemStack InventoryProfilesNext's locked state, skip it.", e);
            }
        }
        return Optional.empty();
    }

}
