package io.github.deerjump.menuplayground.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;

public class TestMenu extends BaseMenu {

    public TestMenu() {
        super("Example");
        getInventory().setItem(0, new ItemStack(DIRT));
        getInventory().setItem(1, new ItemStack(STONE));
        getInventory().setItem(2, new ItemStack(GRASS));
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public boolean onClick(Player player, int slot, ClickType type) {
        switch (slot) {
            case 0: { player.sendMessage(type + " clicked on the dirt"); break; }
            case 1: { player.sendMessage(type + " clicked on the stone"); break; }
            case 2: { player.sendMessage(type + " clicked on the grass"); break; }
            default: { player.sendMessage(type + " clicked on an empty slot"); break; }
        }
        player.sendMessage("You clicked on the " + this.getInventory().getItem(slot).getType() + ". It was in slot: " + slot);
        return true;
    }

    @Override
    public void onOpen(Player player) {

    }

    @Override
    public void onClose(Player player) {

    }
}