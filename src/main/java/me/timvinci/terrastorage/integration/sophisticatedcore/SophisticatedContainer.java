package me.timvinci.terrastorage.integration.sophisticatedcore;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.p3pp3rf1y.sophisticatedcore.inventory.InventoryHandler;

public class SophisticatedContainer implements Container {

    private final InventoryHandler inventoryHandler;

    public SophisticatedContainer(InventoryHandler inventoryHandler) {
        this.inventoryHandler = inventoryHandler;
    }

    public InventoryHandler getInventoryHandler() {
        return inventoryHandler;
    }

    @Override
    public int getContainerSize() {
        return inventoryHandler.getSlots();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < getContainerSize(); i++) {
            ItemStack stack = inventoryHandler.getStackInSlot(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return inventoryHandler.getStackInSlot(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack itemStack = inventoryHandler.extractItem(slot, amount, true);
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (itemStack.getCount() < amount) {
            return ItemStack.EMPTY;
        } else if (itemStack.getCount() == amount) {
            return inventoryHandler.extractItem(slot, amount, false);
        } else {
            itemStack = inventoryHandler.extractItem(slot, amount, false);
            itemStack.split(amount);
            return itemStack;
        }
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack stackInSlot = inventoryHandler.getStackInSlot(slot);
        inventoryHandler.setStackInSlot(slot, ItemStack.EMPTY);
        return stackInSlot;
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        inventoryHandler.setStackInSlot(slot, itemStack);
    }

    @Override
    public void setChanged() {
        inventoryHandler.changeSlots(0);
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
