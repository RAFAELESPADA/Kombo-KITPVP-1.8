package net.kombopvp.pvp.command;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.kombopvp.kit2.Stomper;
import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.cooldown2.WaveCooldown2;
import net.kombopvp.pvp.kit.Habilidade;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.KitManager2;
import net.kombopvp.pvp.kit.provider.EnderMageReal;
import net.kombopvp.pvp.kit.provider.GladiatorListener2;
import net.kombopvp.pvp.listener.Jump;
import net.kombopvp.pvp.listener.PlayerJoin;
import net.kombopvp.pvp.warp.WarpDuoBattleHandle;
import net.kombopvp.pvp.warp.WaveWarp2;
import net.kombopvp.warp.provider.Gladiator;
import net.kombopvp.warp.provider.OneVsOne;
import net.kombopvp.warp.provider.Sumo;
import net.wavemc.core.bukkit.WaveBukkit;
import net.wavemc.core.bukkit.account.WavePlayer;

public class SpawnCMD extends WarpDuoBattleHandle implements Listener, CommandExecutor {
	
	public SpawnCMD() {
		 super("spawn_pos1", "spawn_pos2", "rolada", "penis", "penisduro", "bucertinha");
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<String> indo = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		Player player = (Player) sender;
		if (WaveWarp2.FPS.hasPlayer(player.getName())) {
			WaveWarp2.FPS.send(player);
			return true;
		}
		if (WaveWarp2.DUELS.hasPlayer(player.getName()) || WaveWarp2.LOBBY.hasPlayer(player.getName())) {
			p.sendMessage("Comando desconhecido.");
			return true;
		}
		if (WaveWarp2.LAVACHALLENGE.hasPlayer(player.getName())) {
			WaveWarp2.LAVACHALLENGE.send(player);
			return true;
		}
		if (WaveWarp2.ARENABUILD.hasPlayer(player.getName())) {
			WaveWarp2.ARENABUILD.send(player);
			return true;
		}
		if (WaveWarp2.SPAWN.hasPlayer(p.getName()) && !KitManager.getPlayer(p.getName()).hasKit() && !KitManager2.getPlayer(p.getName()).haskit2() && !Jump.recebeu.containsKey(player.getName())) {
			p.sendMessage(ChatColor.RED + "Você já está no spawn.");
			return true;
		}
		else if (player.getLocation().getY() > KomboPvP.getInstance().getConfig().getInt("SpawnAltura") && PlayerJoin.fall.contains(player)  && EnderMageReal.isSpawn(p.getLocation())) {
	      	player.sendMessage("§cVocê já está no spawn!");
	  		return true;
	  	 }
		 if (GladiatorListener2.combateGlad.containsKey(p)) {
				p.sendMessage("§eComando bloqueado no Gladiator!");
			
				return true;
         }
		 if (net.kombopvp.kit2.GladiatorListener.combateGlad.containsKey(p)) {
				p.sendMessage("§eComando bloqueado no Gladiator!");
				
				return true;
         }
		 if (Sumo.fastChallenge.contains(p)) {
			 Sumo.fastChallenge.remove(p);
			 p.sendMessage(ChatColor.GREEN + "Você saiu da fila da sumo");
		 }
		 if (OneVsOne.fastChallenge.contains(p)) {
			 OneVsOne.fastChallenge.remove(p);
			 p.sendMessage(ChatColor.GREEN + "Você saiu da fila da 1v1");
		 }
		 if (Gladiator.fastChallenge.contains(p)) {
			 Gladiator.fastChallenge.remove(p);
			 p.sendMessage(ChatColor.DARK_RED + "Você saiu da fila do gladiator");
		 }
		 
		Habilidade.removeAbility(p);
		WaveWarp2.SPAWN.send(p, true);
		p.setFlying(false);
		if (!PlayerJoin.fall.contains(p)) {
	    	PlayerJoin.fall.add(p);
	    
	    }
	    WaveCooldown2.removeCooldown(player, KitManager2.getPlayer(player.getName()).getkit2().getName());
	    net.kombopvp.pvp.cooldown1.WaveCooldown2.removeCooldown(player, KitManager.getPlayer(player.getName()).getKit().getName());
		Stomper.usou.remove(p.getName());
		net.kombopvp.pvp.kit.provider.Stomper.usou.remove(player.getName());
		p.setGameMode(GameMode.SURVIVAL);
		p.setLevel(0);
		return true;
	
	

		
	}
	@EventHandler
    public void PlayerMove(PlayerMoveEvent event) {
        if (event.isCancelled()) return;
        Player player = event.getPlayer();
        if (!KitManager.getPlayer(player.getName()).hasKit()) {
        	return;
        }
        else if (indo.contains(player.getName())) {
        	indo.remove(player.getName());
        }
}
}