package me.timvinci.terrastorage.item;

import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Compact helper class to encapsulate the stack checking and processing logic.
 */
public class StackProcessor {
    private final Predicate<Tuple<ItemStack, Integer>> shouldProcess;
    private final Consumer<ItemStack> process;

    public StackProcessor(Predicate<Tuple<ItemStack, Integer>> shouldProcess, Consumer<ItemStack> process) {
        this.shouldProcess = shouldProcess;
        this.process = process;
    }

    public boolean tryProcess(ItemStack stack, Integer slotIndex) {
        if (shouldProcess.test(new Tuple<>(stack, slotIndex))) {
            process.accept(stack);
            return true;
        }

        return false;
    }
}
