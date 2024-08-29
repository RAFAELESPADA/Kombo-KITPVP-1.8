package net.kombopvp.pvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.kombopvp.pvp.command.NoBreakEvent;
import net.kombopvp.pvp.kit.Habilidade;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.provider.GladiatorListener2;
import net.kombopvp.pvp.warp.WaveWarp2;
import net.kombopvp.warp.provider.Duels;

public class PlayerQuitListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage(null);

		WaveWarp2.removeHandle(player.getName());
	  NoBreakEvent.embuild.remove(player);
	KitManager.remove(player.getName());
	Habilidade.removeAbility(player);
	
		
		  if (player.getScoreboard().getObjective("pvp") == null && player.getScoreboard().getObjective("pvp2") == null && player.getScoreboard().getObjective("pvpg") == null && player.getScoreboard().getObjective("pvppt") == null && player.getScoreboard().getObjective("pvp3") == null && player.getScoreboard().getObjective("pvp4") == null && player.getScoreboard().getObjective("pvp5") == null && player.getScoreboard().getObjective("pvp6") == null  && player.getScoreboard().getObjective("pvp7") == null) {
				return;
			}
		 
	      
Player p = player;
if (ArenaBuild.blocks != null) {
	      		for (Location l : ArenaBuild.blocks) {
	      			l.getBlock().setType(Material.AIR);	
	      		}
	      	}
	      		if (ArenaBuild.placed_blocks.get(p) != null) {
	      for (Block b : ArenaBuild.placed_blocks.get(p)) {
	      	  b.setType(Material.AIR);
	      }
	    
		  
		  if (Duels.protector.containsKey(player.getName())) {
			    Duels.protector.remove(player.getName());
			    }

		 if (GladiatorListener2.combateGlad.containsKey(player)) {
             final Player winner = GladiatorListener2.combateGlad.get(player);
             final Player loser = player;
             GladiatorListener2.resetGladiatorListenerByQuit(winner, loser);
             GladiatorListener2.combateGlad.remove(winner);
             GladiatorListener2.combateGlad.remove(loser);
		 }
		 else if (net.kombopvp.kit2.GladiatorListener.combateGlad.containsKey(player)) {
             final Player winner = GladiatorListener2.combateGlad.get(player);
             for (Player p2 : Bukkit.getOnlinePlayers()) {
            	 if (net.kombopvp.kit2.GladiatorListener.combateGlad.containsKey(p2)) {
            		 p2.damage(p2.getHealth()); 
            	 }
            	 
             }
         }
	      		}}

}
