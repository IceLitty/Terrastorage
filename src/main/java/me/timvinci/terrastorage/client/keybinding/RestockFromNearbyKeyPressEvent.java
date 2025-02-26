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
public class RestockFromNearbyKeyPressEvent {

    @SubscribeEvent
    public static void onReloadPress(InputEvent.Key event) {
        if (QuickStackToNearbyKeyPressEvent.isInGame() && event.getAction() == GLFW.GLFW_PRESS
                && TerrastorageKeybindings.restockFromNearbyBind.matches(event.getKey(), event.getScanCode())
                && TerrastorageKeybindings.restockFromNearbyBind.getKeyModifier().equals(KeyModifier.getActiveModifier())) {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player == null || player.isSpectator()) {
                return;
            }
            ClientNetworkHandler.sendActionPayload(StorageAction.RESTOCK_FROM_NEARBY);
        }
    }

}
