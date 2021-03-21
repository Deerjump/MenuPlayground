package io.github.deerjump.menuplayground.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public  abstract class BaseMenu implements Menu {
    protected final Inventory inventory;

    public BaseMenu() {
        this("Menu");
    }

    public BaseMenu(String title) {
        this.inventory = Bukkit.createInventory(this, 9, title);
    }

    public BaseMenu(InventoryType type) {
        this(type, "Menu");
    }

    public BaseMenu(InventoryType type, String title) {
        this.inventory = Bukkit.createInventory(this, type, title);
    }

    public BaseMenu(int size) {
        this(size, "Menu");
    }

    public BaseMenu(int size, String title) {
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        return true;
    }

    @Override
    public abstract void onOpen(Player player);

    @Override
    public abstract void onClose(Player player);
}
