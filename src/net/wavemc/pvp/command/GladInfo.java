package net.wavemc.pvp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.wavemc.pvp.warp.WaveWarp2;



public class GladInfo implements CommandExecutor {
	


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player target;
		
		if (label.equalsIgnoreCase("warpinfo") && sender instanceof Player) {
	         target = (Player)sender;
	         if (!target.hasPermission("wave.cmd.warpinfo")) {
	        	  target.sendMessage("§eSem permissão");
	        	  return true;
	         }
	         target.sendMessage("§e** WARP INFO §e**");
	         target.sendMessage("§aJogadores No Spawn: §e" + WaveWarp2.SPAWN.getPlayerCount());
	         target.sendMessage("§aJogadores No FPS: §e" + WaveWarp2.FPS.getPlayerCount());
	         target.sendMessage("§aJogadores No LAVA: §e" + WaveWarp2.LAVACHALLENGE.getPlayerCount());
	         target.sendMessage("§aJogadores No DUELS: §e" + WaveWarp2.DUELS.getPlayerCount());
	        
	               return false;
	            }
	



		return false;
	}
}
