package io.github.deerjump.menuplayground.menus.impl;

import io.github.deerjump.builders.SkullBuilder;
import io.github.deerjump.menuplayground.menus.BaseMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;

import static io.github.deerjump.menuplayground.menus.MenuHeads.GLOBE;
import static org.bukkit.ChatColor.BLUE;
import static org.bukkit.ChatColor.WHITE;

public class MainMenu extends BaseMenu {

    private static final String MENU_TITLE = "Main Menu";

    public MainMenu() {
        super(MENU_TITLE);
    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        switch(slot) {
            case 0: { player.openInventory(new PlayerMenu().getInventory()); break; }
            case 1: { player.openInventory(new ServerMenu().getInventory()); break; }
        }
        return true;
    }

    @Override
    public void onOpen(Player player) {
        inventory.setItem(0, new SkullBuilder(player.getName()).name(WHITE, player.getName()).lore(BLUE + "Click to see your stats!").build());
        inventory.setItem(1, new SkullBuilder().setUrl(GLOBE).name(WHITE, "Click to see server stats!").build());
    }

    @Override
    public void onClose(Player player) {

    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}