package net.kombopvp.pvp.command;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.cooldown2.WaveCooldown2;
import net.kombopvp.pvp.kit.Habilidade;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.KitManager2;
import net.kombopvp.pvp.kit.provider.EnderMageReal;
import net.kombopvp.pvp.kit.provider.GladiatorListener2;
import net.kombopvp.pvp.listener.ArenaBuild;
import net.kombopvp.pvp.listener.Jump;
import net.kombopvp.pvp.listener.PlayerJoin;
import net.kombopvp.pvp.warp.WarpDuoBattleHandle;
import net.kombopvp.pvp.warp.WaveWarp2;
import net.kombopvp.warp.provider.Duels;
import net.kombopvp.warp.provider.Gladiator;
import net.kombopvp.warp.provider.Lobby2;
import net.kombopvp.warp.provider.OneVsOne;
import net.kombopvp.warp.provider.Sumo;
import net.wavemc.core.bukkit.WaveBukkit;
import net.wavemc.core.bukkit.account.WavePlayer;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class Lobby implements CommandExecutor {
	
	

	public static ArrayList<String> indo = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		Player player = (Player) sender;
		 if (GladiatorListener2.combateGlad.containsKey(p)) {
				p.sendMessage("§eComando bloqueado no Gladiator!");
				return true;
      }
		 if (net.kombopvp.kit2.GladiatorListener.combateGlad.containsKey(p)) {
				p.sendMessage("§eComando bloqueado no Gladiator!");
				return true;
      }
		 try {
		if (WaveWarp2.SPAWN.hasPlayer(p.getName()) || WaveWarp2.FPS.hasPlayer(p.getName()) || WaveWarp2.DUELS.hasPlayer(p.getName()) || WaveWarp2.LAVACHALLENGE.hasPlayer(p.getName()) || WaveWarp2.ARENABUILD.hasPlayer(p.getName())) {
			WaveWarp2.LOBBY.send(player);
		}
		 }
		  catch (NullPointerException e) {
				player.getInventory().clear();
			    WaveCooldown2.removeCooldown(player, KitManager2.getPlayer(player.getName()).getkit2().getName());
			    net.kombopvp.pvp.cooldown1.WaveCooldown2.removeCooldown(player, KitManager.getPlayer(player.getName()).getKit().getName());
		    Jump.recebeu.remove(player.getName());
		    if (Duels.protector.containsKey(player.getName())) {
		        Duels.protector.remove(player.getName());
		        }
			KitManager.getPlayer(player.getName()).removeKit();
			KitManager2.getPlayer(player.getName()).removekit2();
			 player.getInventory().setItem(3, new ItemBuilder("§bModos de jogo §7(Clique)", Material.COMPASS)
						.nbt("cancel-drop")
						.nbt("cancel-click")
						.nbt("modos", "spawn")
						.toStack()
				);
			 player.getInventory().setItem(5, new ItemBuilder(Lobby2.getHead(player))
						.nbt("cancel-drop")
						.nbt("cancel-click")
						.nbt("modos", "spawn")
						.toStack()
				);
			 player.getInventory().setItem(4, new ItemBuilder("§bKangarinho §7(Clique)", Material.FIREWORK)
						.nbt("cancel-drop")
						.nbt("cancel-click")
						.nbt("kit-handler", "kangaroo")
						.toStack()
				);
			 player.teleport(new Location(Bukkit.getWorld("lobbypvp"), 24 , 69, 0));
		}
		  
			
		 
		 
		 
	if (player != null) {
		if (ArenaBuild.placed_blocks.get(p) == null) {
			return true;
		}
                  for (Block b : ArenaBuild.placed_blocks.get(p)) {
                	  b.setType(Material.AIR);
                }
			return true;			
		}
		
		
		else if (WaveWarp2.LOBBY.hasPlayer(p.getName())) {
			
			player.sendMessage(ChatColor.GREEN + "Clique no NPC de voltar ao lobby para voltar.");
		}
		return false;
		 }
}

