package me.timvinci.terrastorage.mixin;

import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * A mixin accessor for the CompoundContainer class.
 */
@Mixin(CompoundContainer.class)
public interface DoubleInventoryAccessor {

    @Accessor("container1")
    Container first();

    @Accessor("container2")
    Container second();
}
