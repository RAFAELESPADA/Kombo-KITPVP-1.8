package net.kombopvp.pvp.kit.provider;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.kombopvp.pvp.kit.KitHandler;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.WaveKit;

public class Turtle extends KitHandler {

    @EventHandler (ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) ||
        !(event.getDamager() instanceof Player)) return;

        Player damager = (Player) event.getDamager();
        if (!KitManager.getPlayer(damager.getName()).hasKit(WaveKit.TURTLE) ||
            !damager.isSneaking()) return;

        event.setDamage(event.getDamage() - 4.5);

    }
}