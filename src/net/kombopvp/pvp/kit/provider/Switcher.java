package net.kombopvp.pvp.kit.provider;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.KitHandler;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.KitManager2;
import net.kombopvp.pvp.kit.WaveKit;
import net.kombopvp.pvp.kit.WaveKit2;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class Switcher extends KitHandler {


    @Override
    public void execute(Player player) {
        super.execute(player);

        player.getInventory().setItem(1, new ItemBuilder(Material.SNOW_BALL)
                .amount(2)
                .nbt("cancel-drop").nbt("kit-handler", "switcher")
                .toStack()
        );
    }
        
@EventHandler
public void snowball(final ProjectileLaunchEvent e) {
    if (e.getEntity() instanceof Snowball) {
    	if (e.getEntity().getShooter() instanceof Player) {
        final Player p = (Player) e.getEntity().getShooter();
        if (!KitManager.getPlayer(p.getName()).hasKit(this)  || !p.getItemInHand().equals(new ItemStack(Material.SNOW_BALL))) {
        	return;
        }
        if (GladiatorListener2.combateGlad.containsKey(p) || net.kombopvp.kit2.GladiatorListener.combateGlad.containsKey(p)) {
            p.sendMessage("§7Não use o switcher no Gladiator!");
            e.setCancelled(true);
            return;
        }
        if (inCooldown(p)) {
        	e.setCancelled(true);
            sendMessageCooldown(p);
            p.getInventory().addItem(new ItemBuilder(Material.SNOW_BALL)
                    .amount(1)
                    .nbt("cancel-drop").nbt("kit-handler", "switcher")
                    .toStack());
            p.sendMessage("§cAguarde para usar novamente!");
            return;
        }
            if (inCooldown(p) && KitManager.getPlayer(p.getName()).hasKit(this)) {
             e.setCancelled(true);
             sendMessageCooldown(p);
             p.getInventory().addItem(new ItemBuilder(Material.SNOW_BALL)
                     .amount(1)
                     .nbt("cancel-drop").nbt("kit-handler", "switcher")
                     .toStack());
             return;
            }
            p.getInventory().addItem(new ItemBuilder(Material.SNOW_BALL)
                    .amount(1)
                    .nbt("cancel-drop").nbt("kit-handler", "switcher")
                    .toStack());
            addCooldown(p , KomboPvP.getInstance().getConfig().getInt("SwitcherCooldown"));
        }
    
    }
}
    	  @EventHandler
    	  public void snowball(EntityDamageByEntityEvent e) {
    	    if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
    	    	
    	      Snowball s = (Snowball)e.getDamager();
    	      if (s.getShooter() instanceof Player) {
    	        Player shooter = (Player)s.getShooter();
    	        if (!KitManager.getPlayer(shooter.getName()).hasKit(this)) {
                	return;
                }
    	        else if (shooter.getLocation().getY() > KomboPvP.getInstance().getConfig().getInt("SpawnAltura") && EnderMageReal.isSpawn(shooter.getLocation())) {
    	        	shooter.sendMessage("§cNão use seu poder no spawn!");
    	    		return;
    	       }
if (inCooldown(shooter)) {
                	
                    shooter.sendMessage("§4Aguarde para usar novamente!");
                    return;
                }
    	        Player p = (Player)e.getEntity();
    	        if (KitManager.getPlayer(p.getName()).hasKit(WaveKit.NEO) || KitManager2.getPlayer(p.getName()).haskit2(WaveKit2.NEO)) {
					p.playSound(p.getLocation(), Sound.NOTE_BASS, 15.0f, 15.0f);
					shooter.sendMessage(ChatColor.AQUA + "Você não pode usar o switcher em " + p.getName() + " porque ele está de kit NEO.");
					return;
				}
    	        if (!KitManager.getPlayer(p.getName()).hasKit()) {
    	          return; 
    	        }
    	        Location shooterLoc = shooter.getLocation();
    	        shooter.teleport(e.getEntity().getLocation());
    	        p.teleport(shooterLoc);
    	        shooter.playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 10.0F, 10.0F);
    	        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10.0F, 10.0F);
    	      } 
    }
}
}

