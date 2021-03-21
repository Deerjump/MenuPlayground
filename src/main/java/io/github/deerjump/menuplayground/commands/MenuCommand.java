package io.github.deerjump.menuplayground.commands;

import io.github.deerjump.menuplayground.menus.impl.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        player.openInventory(new MainMenu().getInventory());

        return true;
    }
}
