package me.timvinci.terrastorage.util;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

/**
 * Simple text styling utility.
 */
public class TextStyler {

    private static final ChatFormatting TITLE_COLOR = ChatFormatting.AQUA;
    private static final ChatFormatting TEXT_COLOR = ChatFormatting.WHITE;
    private static final ChatFormatting VALUE_COLOR = ChatFormatting.YELLOW;
    private static final ChatFormatting ERROR_COLOR = ChatFormatting.RED;
    private static final ChatFormatting WARNING_COLOR = ChatFormatting.GOLD;

    private static final ChatFormatting ENABLED_COLOR = ChatFormatting.GREEN;
    private static final ChatFormatting DISABLED_COLOR = ChatFormatting.RED;

    public static MutableComponent styleTitle(String title) {
        return Component.literal(title).withStyle(style -> style.withBold(true).withColor(TITLE_COLOR));
    }

    public static MutableComponent styleText(MutableComponent text) {
        return text.withStyle(style -> style.withBold(false).withColor(TEXT_COLOR));
    }

    public static <T> MutableComponent styleGetProperty(String propertyName, T value, String valueUnit) {
        return styleTitle(propertyName + ": ")
                    .append(Component.literal(value + valueUnit)
                    .withStyle(style -> style.withBold(false).withColor(VALUE_COLOR))
        );
    }

    public static <T> MutableComponent stylePropertyUpdated(String propertyName, T value, String valueUnit) {
        return styleTitle(propertyName + " Updated\n")
                    .append(Component.literal("New value: ")
                    .withStyle(style -> style.withBold(false).withColor(TEXT_COLOR)))
                    .append(Component.literal(value + valueUnit)
                    .withStyle(style -> style.withColor(VALUE_COLOR))
        );
    }

    public static MutableComponent styleBooleanValue(boolean value) {
        return Component.translatable("terrastorage.option." + (value ? "enabled" : "disabled"))
                .withStyle(style -> style.withColor(value ? ENABLED_COLOR : DISABLED_COLOR));
    }

    public static MutableComponent error(String messageKey) {
        return Component.translatable(messageKey).withStyle(ERROR_COLOR);
    }

    public static MutableComponent warning(String messageKey) {
        return Component.translatable(messageKey).withStyle(WARNING_COLOR);
    }
}
