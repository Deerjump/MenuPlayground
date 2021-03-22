package io.github.deerjump.menuplayground.menus.impl;

import io.github.deerjump.builders.ItemBuilder;
import io.github.deerjump.builders.SkullBuilder;
import io.github.deerjump.menuapi.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import static io.github.deerjump.menuplayground.menus.MenuHeads.GLOBE;
import static org.bukkit.ChatColor.BLUE;
import static org.bukkit.ChatColor.WHITE;

public class MainMenu extends Menu {

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

        fill(new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).build());
    }

    @Override
    public void onClose(Player player) {

    }
}