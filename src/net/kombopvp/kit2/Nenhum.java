package net.kombopvp.kit2;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.KitHandler2;

public class Nenhum extends KitHandler2 {

	 @Override
	    public void execute(Player player) {
	        super.execute(player);

	        new BukkitRunnable() {
	    		@Override
	    		public void run() {
	    	player.closeInventory();
	    		runTask(KomboPvP.getInstance());
	    		}
	    	};
	        
	    }
}