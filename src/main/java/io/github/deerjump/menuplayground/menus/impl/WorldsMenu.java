package io.github.deerjump.menuplayground.menus.impl;

import io.github.deerjump.builders.ItemBuilder;
import io.github.deerjump.builders.SkullBuilder;
import io.github.deerjump.menuapi.Menu;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import static io.github.deerjump.menuplayground.menus.MenuHeads.BACK_ARROW;
import static io.github.deerjump.menuplayground.menus.MenuHeads.END_GLOBE;
import static io.github.deerjump.menuplayground.menus.MenuHeads.GLOBE;
import static io.github.deerjump.menuplayground.menus.MenuHeads.NETHER_GLOBE;
import static org.bukkit.ChatColor.BLUE;
import static org.bukkit.ChatColor.WHITE;
import static org.bukkit.Material.GRAY_STAINED_GLASS_PANE;

public class WorldsMenu extends Menu {
    private static final String MENU_TITLE = "Worlds Menu";

    public WorldsMenu() {
        super(54, MENU_TITLE);
    }

    @Override
    @SuppressWarnings({"SwitchStatementWithTooFewBranches", "ConstantConditions"})
    public boolean onClick(Player player, int slot, ClickType type) {
        if (slot >= inventory.getSize() || slot < 0) return false;

        switch (slot) {
            case 45: { player.openInventory(new ServerMenu().getInventory()); break;}
            default: {
                if (inventory.getItem(slot) != null && inventory.getItem(slot).getType() != GRAY_STAINED_GLASS_PANE)
                    player.teleport(Bukkit.getWorlds().get(slot).getSpawnLocation());
            }
        }
        return true;
    }

    @Override
    public void onOpen(Player player) {
        int count = 0;

        for (World world : Bukkit.getWorlds()) {
            if (count > inventory.getSize() - 9) break;
            String lore = String.format("Players: %s", world.getPlayers().size());
            String iconSkin = GLOBE;
            switch (world.getEnvironment()) {
                case NETHER: { iconSkin = NETHER_GLOBE; break; }
                case THE_END: { iconSkin = END_GLOBE; break; }
            }
            inventory.setItem(count, new SkullBuilder().setUrl(iconSkin).name(WHITE, world.getName()).lore(BLUE, lore).build());
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
