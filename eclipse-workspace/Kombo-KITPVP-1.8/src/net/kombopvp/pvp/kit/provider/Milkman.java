package net.kombopvp.pvp.kit.provider;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.KitHandler;
import net.kombopvp.pvp.kit.KitManager;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class Milkman extends KitHandler {

    @Override
    public void execute(Player player) {
        super.execute(player);

        player.getInventory().setItem(1, new ItemBuilder(Material.MILK_BUCKET)
                .displayName("§fMilkMan")
                .nbt("cancel-drop")
                .nbt("kit-handler", "milkman")
                .toStack()
        );
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
    	if (event.getItem() == null) {
			return;
		}
    	if (event.getItem().getType().equals(Material.MUSHROOM_SOUP)) {
			return;
		}
        if (!event.hasItem() || !ItemBuilder.has(event.getItem(), "kit-handler", "milkman")) {
        	return;
        }
      
        if (inCooldown(event.getPlayer()) && KitManager.getPlayer(event.getPlayer().getName()).hasKit(this)) {
        	   event.setCancelled(true);
			sendMessageCooldown(event.getPlayer());
			return;
		}
        event.setCancelled(true);
        addCooldown(event.getPlayer(), KomboPvP.getInstance().getConfig().getInt("MilkManCooldown"));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 5 * 20, 0));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10 * 20, 0));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * 20, 0));
        event.getPlayer().sendMessage("§aMilkman aplicado!");
    }
}