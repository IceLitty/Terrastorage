package me.timvinci.terrastorage.mixin;

import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * A mixin accessor for the BaseContainerBlockEntity class.
 */
@Mixin(BaseContainerBlockEntity.class)
public interface LockableContainerBlockEntityAccessor {
    @Accessor("name")
    void setCustomName(Component customName);

    @Invoker("getDefaultName")
    Component invokeGetContainerName();
}
