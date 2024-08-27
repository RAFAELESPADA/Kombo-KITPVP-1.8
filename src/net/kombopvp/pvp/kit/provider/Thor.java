package net.kombopvp.pvp.kit.provider;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.KitHandler;
import net.kombopvp.pvp.kit.KitManager;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class Thor extends KitHandler {
	
	@Override
	public void execute(Player player) {
		super.execute(player);
		
		player.getInventory().setItem(1, new ItemBuilder("§eCaboom!", Material.GOLD_AXE)
				.nbt("cancel-drop")
				.nbt("kit-handler", "thor")
				.toStack()
		);
	}
	 @EventHandler
	 /*     */   public void OnBlock(BlockIgniteEvent e)
	 /*     */   {
	 /*  95 */     if (e.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING) {
	 /*  96 */       e.setCancelled(true);
	 }
	 /*     */   }
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if (event.getItem() == null) {
			return;
		}
		if (event.getItem().getType().equals(Material.MUSHROOM_SOUP)) {
			return;
		}
		Player player = event.getPlayer();
		if (inCooldown(player) && KitManager.getPlayer(player.getName()).hasKit(this)) {
			sendMessageCooldown(player);
			return;
		}
		if (!KitManager.getPlayer(player.getName()).hasKit(this) 
				|| !event.hasItem() || !ItemBuilder.has(event.getItem(), "kit-handler", "thor") 
				|| event.getClickedBlock() == null || event.getClickedBlock().getType().equals(Material.AIR)) {
			return;
		}
		else if (player.getLocation().getY() > KomboPvP.getInstance().getConfig().getInt("SpawnAltura")) {
			player.sendMessage("§cNão use o thor no spawn!");
			return;
		}
		
		event.setCancelled(true);
		
		
		
		addCooldown(event.getPlayer(), KomboPvP.getInstance().getConfig().getInt("ThorCooldown"));
		player.getWorld().strikeLightning(event.getClickedBlock().getLocation());
		player.getWorld().strikeLightning(event.getClickedBlock().getLocation());
	}

	 /*     */ 
	 @EventHandler
	 /*     */   public void OnBlockBtB(EntityDamageEvent e)
	 /*     */   {
	 /* 110 */     if (!(e.getEntity() instanceof Player)) {
	 /* 111 */       return;
	 /*     */     }
	 /* 113 */     Player p = (Player)e.getEntity();
	 /* 114 */     if (KitManager.getPlayer(p.getName()).hasKit(this) && (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING)) {
	 /* 115 */       e.setCancelled(true);
	 /*     */   }
	 }
	@EventHandler
	public void onBlockExplode(BlockExplodeEvent event) {
		event.setCancelled(true);
	}
}
