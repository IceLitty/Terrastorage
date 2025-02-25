package me.timvinci.terrastorage.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import me.timvinci.terrastorage.mixin.client.PressableWidgetAccessor;
import me.timvinci.terrastorage.util.client.ButtonsStyle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

/**
 * A customized button widget.
 */
public class StorageButtonWidget extends Button {
    private ButtonsStyle buttonStyle;

    public StorageButtonWidget(int x, int y, int width, int height, Component message, ButtonsStyle buttonStyle, Button.OnPress onPress) {
        super(x, y, width, height, message, onPress, Button.DEFAULT_NARRATION);
        this.setButtonStyle(buttonStyle);
    }

    public void setButtonStyle(ButtonsStyle buttonsStyle) {
        this.buttonStyle = buttonsStyle;
    }

    /**
     * Sets the button text color to yellow when the button is hovered, similarly to how it is in Terraria.
     * Supports not drawing the background of the button.
     */
    @Override
    protected void renderWidget(GuiGraphics context, int mouseX, int mouseY, float delta) {
        Minecraft minecraftClient = Minecraft.getInstance();
        context.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();

        // Draw the button background if the option buttons style is set to default.
        if (buttonStyle == ButtonsStyle.DEFAULT) {
            context.blitSprite(PressableWidgetAccessor.getTextures().get(this.active, this.isHoveredOrFocused()), this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
        context.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        // Change the text color to yellow if the button is hovered.
        int i = this.isHovered ? 16776960 : 16777215;
        this.renderString(context, minecraftClient.font, i | Mth.ceil(this.alpha * 255.0F) << 24);
    }
}
