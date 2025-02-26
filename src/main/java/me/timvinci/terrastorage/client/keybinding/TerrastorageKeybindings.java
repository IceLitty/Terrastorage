package me.timvinci.terrastorage.client.keybinding;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

/**
 * Holds the keybindings used by Terrastorage, and a method for registering them.
 */
public class TerrastorageKeybindings {
    public static KeyMapping favoriteItemModifier;
    public static KeyMapping sortInventoryBind;
    public static KeyMapping quickStackToNearbyBind;
    public static KeyMapping restockFromNearbyBind;

    public static void registerKeybindings() {
        favoriteItemModifier = new KeyMapping(
            "terrastorage.keybinding.favorite_item_modifier",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                "terrastorage.keybinding.categories.main"
        );

        KeyBindingHelper.registerKeyBinding(favoriteItemModifier);

        sortInventoryBind = new KeyMapping(
                "terrastorage.keybinding.sort_inventory_bind",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "terrastorage.keybinding.categories.main"
        );

        KeyBindingHelper.registerKeyBinding(sortInventoryBind);

        quickStackToNearbyBind = new KeyMapping(
                "terrastorage.keybinding.quick_stack_to_nearby_bind",
                KeyConflictContext.IN_GAME,
                KeyModifier.SHIFT,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "terrastorage.keybinding.categories.main"
        );

        KeyBindingHelper.registerKeyBinding(quickStackToNearbyBind);

        restockFromNearbyBind = new KeyMapping(
                "terrastorage.keybinding.restock_from_nearby_bind",
                KeyConflictContext.IN_GAME,
                KeyModifier.SHIFT,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_T,
                "terrastorage.keybinding.categories.main"
        );

        KeyBindingHelper.registerKeyBinding(restockFromNearbyBind);
    }
}
