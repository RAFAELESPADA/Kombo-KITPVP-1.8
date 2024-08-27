package net.kombopvp.pvp.kit.provider;


import java.util.concurrent.TimeUnit;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.KitHandler;
import net.kombopvp.pvp.kit.KitManager;
import net.wavemc.core.bukkit.item.ItemBuilder;
import net.wavemc.core.util.WaveCooldown;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

 public class Archer extends KitHandler 
 {
	@Override
	public void execute(Player player) {
		super.execute(player);
		
		player.getInventory().setItem(2, new ItemBuilder("§aArco!", Material.BOW)
				.nbt("kit-handler", "arco").addEnchant(Enchantment.ARROW_KNOCKBACK, 1)
				.nbt("cancel-drop")
				.toStack());
				player.getInventory().setItem(10, new ItemBuilder("§aFlecha!", Material.ARROW)
						.nbt("kit-handler", "flecha").addEnchant(Enchantment.DAMAGE_ALL, 1)
						.nbt("cancel-drop").addFlags(
								ItemFlag.HIDE_ENCHANTS)
						.toStack()
		);
	}


	@SuppressWarnings("deprecation")
	@EventHandler
    public void bowUseEvent(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player) {
      
            Player player = (Player) event.getEntity();
            if (!KitManager.getPlayer(event.getEntity().getName()).hasKit(this)) {
            	return;
            }
          player.getInventory().addItem(new ItemStack(Material.ARROW));
    
          
}
	}}
