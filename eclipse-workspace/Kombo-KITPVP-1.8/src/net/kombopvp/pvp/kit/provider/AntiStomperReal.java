package net.kombopvp.pvp.kit.provider;




	import org.bukkit.entity.Player;

import net.kombopvp.pvp.kit.Habilidade;
import net.kombopvp.pvp.kit.KitHandler;

	public class AntiStomperReal extends KitHandler {

	@Override
	public void execute(Player player) {
		super.execute(player);
		
		Habilidade.setAbility(player, "AntiStomper");
	}
	}

