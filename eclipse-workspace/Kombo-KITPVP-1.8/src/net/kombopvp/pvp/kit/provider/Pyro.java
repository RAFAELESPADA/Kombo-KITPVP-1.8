package net.kombopvp.pvp.kit.provider;

import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.KitHandler;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.WaveKit;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class Pyro extends KitHandler {

	   @Override
	    public void execute(Player player) {
	        super.execute(player);

	   }
	   
@EventHandler(priority = EventPriority.HIGH)
public void onInteract(EntityDamageEvent event) {
	if (!(event.getEntity() instanceof Player)) {
		return;
	}
	Player p = (Player)event.getEntity();
	if (!KitManager.getPlayer(p.getName()).hasKit(this)) {
		return;
	}	
	if (event.getCause() == DamageCause.ENTITY_EXPLOSION) {
		event.setCancelled(true);
	}
}
@EventHandler(priority = EventPriority.LOWEST)
public void onInteract(PlayerInteractEvent event) {
	Player p = event.getPlayer();
	if (event.getItem() == null) {
		return;
	}
	if (event.getItem().getType().equals(Material.MUSHROOM_SOUP)) {
		return;
	}
	if (!KitManager.getPlayer(p.getName()).hasKit(this)) {
		return;
	}

	if (!event.hasItem() || !ItemBuilder.has(event.getItem(), "kit-handler", "pyro")) return; 
	if (!event.getAction().toString().contains("RIGHT")) 
	return; {
		event.setCancelled(true);
		
		if (!inCooldown(event.getPlayer())) {

			new BukkitRunnable() {
	            int fireballs = 0;
	            int total = 5; // total de bolas de fogo

	            @Override
	            public void run() {
	                fireballs++;
	                p.launchProjectile(Fireball.class);
	                if(fireballs >= total) {
	                    cancel();
	                }
	            }
	        }.runTaskTimer(KomboPvP.getInstance(), 0, 10);

			addCooldown(p, 25);
}
}
}
}