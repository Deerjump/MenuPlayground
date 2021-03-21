package io.github.deerjump.menuplayground.menus.impl;

import io.github.deerjump.builders.ItemBuilder;
import io.github.deerjump.builders.SkullBuilder;
import io.github.deerjump.menuplayground.Util;
import io.github.deerjump.menuplayground.menus.BaseMenu;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import java.util.Arrays;
import java.util.List;
import static org.bukkit.ChatColor.*;
import static io.github.deerjump.menuplayground.menus.MenuHeads.BACK_ARROW;
import static org.bukkit.Material.GRAY_STAINED_GLASS_PANE;

public class PlayerMenu extends BaseMenu {
    private static final String MENU_TITLE = "Player Stats";

    public PlayerMenu() {
        super(18, MENU_TITLE);
    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        switch(slot) {
            case 0: { player.sendMessage(String.format("%s", player.getStatistic(Statistic.PLAY_ONE_MINUTE))); break; }
            case 9: { player.openInventory(new MainMenu().getInventory()); break; }
        }
        return true;
    }

    @Override
    public void onOpen(Player player) {
        String playTime = Util.formatTime(player.getStatistic(Statistic.PLAY_ONE_MINUTE));

        List<String> lore = Arrays.asList(
                String.format("%sPlaytime: %s%s", GREEN, WHITE, playTime),
                String.format("%sDeaths: %s%s", GREEN, WHITE, player.getStatistic(Statistic.DEATHS))
        );
        this.inventory.setItem(0, new SkullBuilder(player.getName()).name(WHITE, player.getName()).lore(BLUE, lore).build());

        this.inventory.setItem(9, new SkullBuilder().setUrl(BACK_ARROW).name(WHITE, "Back").lore(BLUE, "Return to Main Menu.").build());
        for (int i = 10; i < getInventory().getSize(); i++) {
            inventory.setItem(i, new ItemBuilder(GRAY_STAINED_GLASS_PANE).name(" ").build());
        }
    }

    @Override
    public void onClose(Player player) {

    }
}
