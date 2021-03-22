package io.github.deerjump.menuplayground.menus.impl;

import io.github.deerjump.builders.ItemBuilder;
import io.github.deerjump.builders.SkullBuilder;
import io.github.deerjump.menuapi.Menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import static io.github.deerjump.menuplayground.menus.MenuHeads.BACK_ARROW;
import static org.bukkit.ChatColor.*;
import static org.bukkit.Material.*;

public class OnlinePlayersMenu extends Menu {
    private static final String MENU_TITLE = String.format("%s/%s", Bukkit.getOnlinePlayers().size(), Bukkit.getMaxPlayers());

    public OnlinePlayersMenu() {
        super(54, MENU_TITLE);
    }

    @Override
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    public boolean onClick(Player player, int slot, ClickType type) {
        switch (slot) {
            case 45: { player.openInventory(new ServerMenu().getInventory()); }
        }

        return true;
    }

    @Override
    public void onOpen(Player player) {
        int count = 0;

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (count > inventory.getSize() - 9) break;
            inventory.setItem(count, new SkullBuilder(p.getName()).name(p.getName()).build());
            count++;
        }

        inventory.setItem(45, new SkullBuilder().setUrl(BACK_ARROW).name(WHITE, "Return to Server Menu").build());
        for (int i = 46; i < getInventory().getSize(); i++) {
            inventory.setItem(i, new ItemBuilder(GRAY_STAINED_GLASS_PANE).name(" ").build());
        }
    }

    @Override
    public void onClose(Player player) {

    }
}
