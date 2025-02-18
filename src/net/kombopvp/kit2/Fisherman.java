package net.kombopvp.kit2;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;

import net.kombopvp.pvp.kit.Habilidade;
import net.kombopvp.pvp.kit.KitHandler2;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.KitManager2;
import net.kombopvp.pvp.kit.WaveKit;
import net.kombopvp.pvp.kit.WaveKit2;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class Fisherman extends KitHandler2 {
	
	@Override
	public void execute(Player player) {
		super.execute(player);
		
		player.getInventory().setItem(2, new ItemBuilder("§aFisgar!", Material.FISHING_ROD)
				.nbt("kit-handler", "fisherman")
				.nbt("cancel-drop")
				.toStack()
		);
	}
	
	@EventHandler
	public void onFish(PlayerFishEvent event) {
		if (!(event.getCaught() instanceof Player) 
				|| !KitManager2.getPlayer(event.getPlayer().getName()).haskit2(this) 
				|| !ItemBuilder.has(event.getPlayer().getItemInHand(), "kit-handler", "fisherman")) {
			return;
		}
		
		Entity caught = event.getCaught();
		 if (KitManager.getPlayer(caught.getName()).hasKit(WaveKit.NEO) || KitManager2.getPlayer(caught.getName()).haskit2(WaveKit2.NEO)) {
			 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.NOTE_BASS, 15.0f, 15.0f);
			 event.getPlayer().sendMessage(ChatColor.AQUA + "Você não pode puxar o jogador " + caught.getName() + " porque ele está de kit NEO");
				return;
			}
		caught.teleport(event.getPlayer());
		caught.sendMessage("§c§lFISHERMAN: §fVocê foi puxado pelo jogador " + event.getPlayer().getName());
		event.getPlayer().sendMessage("§c§lFISHERMAN: §fVocê puxou o jogador " + caught.getName());
	}
}


