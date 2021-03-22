package io.github.deerjump.menuplayground;

import io.github.deerjump.menuapi.MenuListener;
import io.github.deerjump.menuplayground.commands.CreateWorldCommand;
import io.github.deerjump.menuplayground.commands.MenuCommand;
import io.github.deerjump.menuplayground.commands.WorldMenuCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class MenuPlayground extends JavaPlugin implements Listener {

   @Override public void onEnable() {
      Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
      registerCommands();
   }

   @SuppressWarnings("ConstantConditions")
   private void registerCommands() {
      this.getCommand("menu").setExecutor(new MenuCommand());
      this.getCommand("worldcreate").setExecutor(new CreateWorldCommand());
      this.getCommand("worldsMenu").setExecutor(new WorldMenuCommand());
   }
}