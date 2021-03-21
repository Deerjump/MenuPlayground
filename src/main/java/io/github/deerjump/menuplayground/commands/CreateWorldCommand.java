package io.github.deerjump.menuplayground.commands;

import io.github.deerjump.menuplayground.worldgen.EmptyChunkGenerator;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateWorldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("You must specify a name for this world!");
            return true;
        }

        new WorldCreator(args[0]).generator(new EmptyChunkGenerator()).createWorld();

        Bukkit.getLogger().info(args[0] + " world has been created!");
        player.sendMessage(args[0] + " world has been created!");
        return true;
    }
}
