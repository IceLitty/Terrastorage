package me.timvinci.terrastorage.integration.chestwithlegs;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class ChesterEntityContainer implements Container {

    private final IItemHandlerModifiable itemHandler;

    public ChesterEntityContainer(IItemHandlerModifiable itemHandler) {
        this.itemHandler = itemHandler;
    }

    public IItemHandlerModifiable getItemHandler() {
        return itemHandler;
    }

    @Override
    public int getContainerSize() {
        return itemHandler.getSlots();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < getContainerSize(); i++) {
            ItemStack stack = itemHandler.getStackInSlot(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return itemHandler.getStackInSlot(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack itemStack = itemHandler.extractItem(slot, amount, true);
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (itemStack.getCount() < amount) {
            return ItemStack.EMPTY;
        } else if (itemStack.getCount() == amount) {
            return itemHandler.extractItem(slot, amount, false);
        } else {
            itemStack = itemHandler.extractItem(slot, amount, false);
            itemStack.split(amount);
            return itemStack;
        }
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack stackInSlot = itemHandler.getStackInSlot(slot);
        itemHandler.setStackInSlot(slot, ItemStack.EMPTY);
        return stackInSlot;
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        itemHandler.setStackInSlot(i, itemStack);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < getContainerSize(); i++) {
            setItem(i, ItemStack.EMPTY);
        }
    }

}
