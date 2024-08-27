package net.kombopvp.kit2;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import net.kombopvp.pvp.kit.KitHandler2;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.WaveKit;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class PvP extends KitHandler2 {
	
	@Override
	public void execute(Player player) {
		super.execute(player);
		
		if (KitManager.getPlayer(player.getName()).hasKit(WaveKit.PVP)) {
		player.getInventory().setItem(0, new ItemBuilder("§fEspada", Material.STONE_SWORD)
				.addEnchant(Enchantment.DAMAGE_ALL, 1)
				.nbt("cancel-drop")
				.toStack()
		);
		}
	}

}
