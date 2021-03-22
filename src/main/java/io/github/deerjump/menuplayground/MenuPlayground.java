package io.github.deerjump.menuplayground;

import io.github.deerjump.menuplayground.commands.CreateWorldCommand;
import io.github.deerjump.menuplayground.commands.MenuCommand;
import io.github.deerjump.menuplayground.commands.WorldMenuCommand;
import io.github.deerjump.menuplayground.menus.Menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class MenuPlayground extends JavaPlugin implements Listener {

   @Override public void onEnable() {
      Bukkit.getPluginManager().registerEvents(this, this);
      registerCommands();
      Bukkit.getServer().getPluginCommand("kit");
   }


   @SuppressWarnings("ConstantConditions")
   private void registerCommands() {
      this.getCommand("menu").setExecutor(new MenuCommand());
      this.getCommand("worldcreate").setExecutor(new CreateWorldCommand());
      this.getCommand("worldsMenu").setExecutor(new WorldMenuCommand());
   }

   @EventHandler(ignoreCancelled = true)
   private void onClick(InventoryClickEvent event) {
      final InventoryHolder holder = event.getInventory().getHolder();
      if (!(holder instanceof Menu)) return;
      event.setCancelled(((Menu) holder).onClick((Player) event.getWhoClicked(), event.getRawSlot(), event.getClick()));
   }

   @EventHandler private void onOpen(InventoryOpenEvent event) {
      final InventoryHolder holder = event.getInventory().getHolder();
      if (holder instanceof Menu) ((Menu) holder).onOpen((Player)event.getPlayer());
   }

   @EventHandler private void onClose(InventoryCloseEvent event) {
      final InventoryHolder holder = event.getInventory().getHolder();
      if (holder instanceof Menu) ((Menu) holder).onClose((Player)event.getPlayer());
   }
}