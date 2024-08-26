package net.wavemc.pvp.command;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.wavemc.pvp.warp.WaveWarp2;
import net.wavemc.warp.provider.Gladiator;
import net.wavemc.warp.provider.OneVsOne;
import net.wavemc.warp.provider.Sumo;





public class WarpJoin implements CommandExecutor { 

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("warpjoin")){
			 Player player = (Player)sender;
			    
			
			
			if(args.length < 1){
				sender.sendMessage("§cUso correto: /warpjoin <arena, duels, lava , fps>");
				return true;
			}
			else if (!WaveWarp2.LOBBY.hasPlayer(player.getName())) {
				player.sendMessage("§cVocê não está no LOBBY DO PVP");
				return true;
			}
			if (args[0].equalsIgnoreCase("arena")) {
				WaveWarp2.SPAWN.send(player);
			
		}
			if (args[0].equalsIgnoreCase("duels")) {
				WaveWarp2.DUELS.send(player);
			
		}
			if (args[0].equalsIgnoreCase("build")) {
				WaveWarp2.ARENABUILD.send(player);
			
		}
			if (args[0].equalsIgnoreCase("lava")) {
				WaveWarp2.LAVACHALLENGE.send(player);
			
		}
			if (args[0].equalsIgnoreCase("fps")) {
				WaveWarp2.FPS.send(player);
			
		}
		
	}
		return false;
}
	
}
