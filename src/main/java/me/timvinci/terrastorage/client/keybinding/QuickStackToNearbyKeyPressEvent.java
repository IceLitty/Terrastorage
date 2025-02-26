package me.timvinci.terrastorage.client.keybinding;

import me.timvinci.terrastorage.network.ClientNetworkHandler;
import me.timvinci.terrastorage.util.Reference;
import me.timvinci.terrastorage.util.StorageAction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public class QuickStackToNearbyKeyPressEvent {

    @SubscribeEvent
    public static void onReloadPress(InputEvent.Key event) {
        if (isInGame() && event.getAction() == GLFW.GLFW_PRESS
                && TerrastorageKeybindings.quickStackToNearbyBind.matches(event.getKey(), event.getScanCode())
                && TerrastorageKeybindings.quickStackToNearbyBind.getKeyModifier().equals(KeyModifier.getActiveModifier())) {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player == null || player.isSpectator()) {
                return;
            }
            ClientNetworkHandler.sendActionPayload(StorageAction.QUICK_STACK_TO_NEARBY);
        }
    }

    public static boolean isInGame() {
        Minecraft mc = Minecraft.getInstance();
        // no loading overlay
        if (mc.getOverlay() != null) {
            return false;
        }
        // not open gui
        if (mc.screen != null) {
            return false;
        }
        // current window is game window
        if (!mc.mouseHandler.isMouseGrabbed()) {
            return false;
        }
        // choose window
        return mc.isWindowActive();
    }

}
