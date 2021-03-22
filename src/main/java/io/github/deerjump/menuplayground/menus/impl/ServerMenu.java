package io.github.deerjump.menuplayground.menus.impl;

import io.github.deerjump.builders.ItemBuilder;
import io.github.deerjump.builders.SkullBuilder;
import io.github.deerjump.menuapi.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import static io.github.deerjump.menuplayground.menus.MenuHeads.BACK_ARROW;
import static org.bukkit.ChatColor.*;
import static org.bukkit.Material.GRAY_STAINED_GLASS_PANE;

public class ServerMenu extends Menu {
    private static final String MENU_TITLE = "Server Stats";

    public ServerMenu() {
        super(18, MENU_TITLE);
    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        switch (slot) {
            case 1: { player.openInventory(new OnlinePlayersMenu().getInventory()); break; }
            case 2: { player.openInventory(new WorldsMenu().getInventory()); break; }
            case 9: { player.openInventory(new MainMenu().getInventory()); break; }
        }
        return true;
    }

    @Override
    public void onOpen(Player player) {
        inventory.setItem(0, new SkullBuilder().name("Server Name").build());
        inventory.setItem(1, new SkullBuilder().name("Online Players").build());
        inventory.setItem(2, new SkullBuilder().name("Worlds").build());

        inventory.setItem(9, new SkullBuilder().setUrl(BACK_ARROW).name(WHITE, "Back").lore(BLUE, "Return to Main Menu.").build());
        for (int i = 10; i < getInventory().getSize(); i++) {
            inventory.setItem(i, new ItemBuilder(GRAY_STAINED_GLASS_PANE).name(" ").build());
        }
    }

    @Override
    public void onClose(Player player) {

    }
}
