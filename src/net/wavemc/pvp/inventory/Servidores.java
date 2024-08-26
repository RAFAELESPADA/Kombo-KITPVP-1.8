package net.wavemc.pvp.inventory;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import net.wavemc.core.bukkit.item.ItemBuilder;
import net.wavemc.pvp.warp.WaveWarp2;


public class Servidores implements Listener {

	private final static String inventoryName = "Modos de Jogo";
	
	public static void open(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 9 * 3, inventoryName);
		
		inventory.setItem(4, new ItemBuilder("§aGladiator", Material.IRON_FENCE).nbt("glad22").lore( ChatColor.GRAY + "Tem " + ChatColor.GRAY + WaveWarp2.GLADIATOR.getPlayerCount() + " Jogando").toStack());
		
		inventory.setItem(12, new ItemBuilder("§aArena", Material.IRON_CHESTPLATE).nbt("arena").lore( ChatColor.GRAY + "Tem " + ChatColor.GRAY + WaveWarp2.SPAWN.getPlayerCount() + " Jogando").toStack());
		inventory.setItem(10, new ItemBuilder("§aDuels", Material.BLAZE_ROD).nbt("duelsbb").lore( ChatColor.GRAY +"Tem " + ChatColor.GRAY + WaveWarp2.DUELS.getPlayerCount() + " Jogando").toStack());
				
		
		inventory.setItem(14, new ItemBuilder("§aLava", Material.LAVA_BUCKET).nbt("lava").lore( ChatColor.GRAY +"Tem " + ChatColor.GRAY + WaveWarp2.LAVACHALLENGE.getPlayerCount() + " Jogando").toStack());
		inventory.setItem(16, new ItemBuilder("§aFPS", Material.GLASS).nbt("fps").lore( ChatColor.GRAY +"Tem " + ChatColor.GRAY + WaveWarp2.FPS.getPlayerCount() + " Jogando").toStack());
		inventory.setItem(22, new ItemBuilder("§aArena Build", Material.COBBLESTONE).nbt("arenabuild").lore( ChatColor.GRAY +"Tem " + ChatColor.GRAY + WaveWarp2.ARENABUILD.getPlayerCount() + " Jogando").toStack());
		
		player.openInventory(inventory);
	}
	public static String getInventoryName() {
		return inventoryName;
	}
}
