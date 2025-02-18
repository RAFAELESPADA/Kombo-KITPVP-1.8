package net.kombopvp.pvp.kit.provider;




import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;

import net.helix.core.util.HelixCooldown;
import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.KitHandler;
import net.kombopvp.pvp.kit.KitManager;
import net.md_5.bungee.api.ChatColor;

public class MeteorBanana extends KitHandler {

	ArrayList<String> danometeor = new ArrayList();
	ArrayList<Player> subiu = new ArrayList();
	@EventHandler
	/*     */   public void BotaStomper2(EntityDamageEvent e)
	/*     */   {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player)e.getEntity();
		if (!KitManager.getPlayer(e.getEntity().getName()).hasKit(this)) {
			return;
		}
		if (!danometeor.contains(e.getEntity().getName())) {
			return;
		}
		if (inCooldown(p)) {
			return;
		}
		if (!(e.getCause() == DamageCause.FALL)) {
			return;
		}
		e.setCancelled(true);
		for (Entity ent : p.getNearbyEntities(5, 5, 5)) {
			if (!(ent instanceof Player)) {
				return;
			}
				Player p2 = (Player)ent;
				if (!KitManager.getPlayer(p2.getName()).hasKit()) {
					return;
				}
				  else if (p2.getLocation().getY() > KomboPvP.getInstance().getConfig().getInt("SpawnAltura")  && EnderMageReal.isSpawn(p2.getLocation())) {
						return;
					 }
				p2.damage(10);
				p2.playSound(p.getLocation(), Sound.GHAST_SCREAM, 10, 10);
				p2.getWorld().strikeLightning(p2.getLocation());
				p2.setFireTicks(140);
				addCooldown(p , 40);
				p2.sendMessage(ChatColor.RED + "Você foi atingido por um meteor!");
				danometeor.remove(e.getEntity().getName());
			}
		}
	@EventHandler
	/*     */   public void BotaStomper2(PlayerToggleSneakEvent e)
	/*     */   {
		Player p = e.getPlayer();
		if (!subiu.contains(p)) {
			return;
		}
		if (!KitManager.getPlayer(p.getName()).hasKit(this)) {
			return;
		}
		
		if ((e.getPlayer().getItemInHand().getType() != Material.FIREBALL)) {
			return;
		}
		int l = (int)p.getEyeLocation().getDirection().multiply(3.0).add(new Vector(0, 0, 0)).getY();
		if(p.getLocation().getPitch() >= -90 && p.getLocation().getPitch() <= -10) {
	        p.sendMessage(ChatColor.RED + "Você só pode usar o meteor olhando para baixo");
	        return;
	    }
		if (hasCooldown(p))
		/*     */       {
		/*  91 */         sendMessageCooldown(p);
		/*  92 */         return;
		/*     */       }
		 p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		/*  76 */       p.setVelocity(p.getEyeLocation().getDirection().multiply(2.0).add(new Vector(0, 0, 0)));
		danometeor.add(p.getName());
		subiu.remove(p);

	/* 102 */       Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */           if (KitManager.getPlayer(p.getName()).hasKit()) {
	    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	/* 107 */           p.sendMessage(ChatColor.GREEN + "Você pode usar o meteor de novo");
	/*     */         }
	/*     */         }

	}

	/* 109 */       , 800L);
	/*     */     }
	private static double calcMotY(double targetY) {
	    double y = 0;
	    double motY = 0;
	    while(y <= targetY) {
	        motY /= 0.98;
	        motY += 0.08;
	        y += motY;
	    }
	    return motY;
	}
	@EventHandler
	/*     */   public void BotaStomper(PlayerInteractEvent e)
	/*     */   {
	/*  84 */     final Player p = e.getPlayer();
	/*  85 */     if (!KitManager.getPlayer(e.getPlayer().getName()).hasKit(this)) {
		return;
	}
	/*     */     
		if ((e.getPlayer().getItemInHand().getType() != Material.FIREBALL)) {
			return;
		}
	/*  87 */       e.setCancelled(true);
	/*  88 */       p.updateInventory();
	/*  89 */       if (hasCooldown(p))
	/*     */       {
	/*  91 */         sendMessageCooldown(p);
	/*  92 */         return;
	/*     */       }
	else if (p.getLocation().getY() > KomboPvP.getInstance().getConfig().getInt("SpawnAltura") && KitManager.getPlayer(e.getPlayer().getName()).hasKit(this)  && EnderMageReal.isSpawn(p.getLocation())) {
		p.sendMessage("§cNão use seu poder no spawn!");
		return;
	 }
	if (!subiu.contains(p)) {
		  if (HelixCooldown.has(p.getName(), "meteor")) {
			  p.sendMessage(ChatColor.RED + "Aguarde " + HelixCooldown.getTime(p.getName(), "meteor") +  " segundos para dar o boost novamente");
			  return;
		  }
	HelixCooldown.create(p.getName(), "meteor", TimeUnit.SECONDS, 15);
	Bukkit.getScheduler().runTaskLater(KomboPvP.getInstance() , new Runnable() {
	    @Override
	    public void run() {
	   	HelixCooldown.delete(p.getName(), "meteor");
	        }
	    }
	, 15 * 20);
	/*  94 */      	 p.setVelocity(new Vector(0, calcMotY(16), 0));

	/* 107 */           p.sendMessage(ChatColor.RED + "APERTE SHIFT PARA USAR O METEOR QUANDO ESTIVER NO ALTO!");
	/*  98 */       Location loc = p.getLocation();
	/*  99 */       p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);
	Location location = p.getLocation();
	for (final Entity pertos : p.getNearbyEntities(20, 20 , 20)) {
		  if (pertos instanceof Player) {
			  ((Player) pertos).playSound((Location)pertos.getLocation(), Sound.ANVIL_BREAK, 1f, 1f);
	}

	location.getWorld().playEffect(location, Effect.FLAME, 15);

	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);
	location.getWorld().playEffect(location, Effect.FLAME, 15);

	/*     */         }
	/* 109 */       }, 20L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);
	location.getWorld().playEffect(location, Effect.FLAME, 15);

	/*     */         }
	/* 109 */       }, 40L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.FLAME, 15);
	/*     */         }
	/* 109 */       }, 60L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.BLAZE_SHOOT, 15);
	/*     */         }
	/* 109 */       }, 80L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.FLAME, 15);
	/*     */         }
	/* 109 */       }, 100L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.FLAME, 15);
	/*     */         }
	/* 109 */       }, 120L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.FLAME, 15);
	/*     */         }
	/* 109 */       }, 130L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.FLAME, 15);
	/*     */         }
	/* 109 */       }, 140L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.FLAME, 15);
	/*     */         }
	/* 109 */       }, 155L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	location.getWorld().playEffect(location, Effect.FLAME, 15);
	/*     */         }
	/* 109 */       }, 160L);
	Bukkit.getScheduler().scheduleSyncDelayedTask(KomboPvP.getInstance(), new Runnable()
	/*     */       {
	/*     */         public void run()
	/*     */         {
	/* 106 */          p.playSound(loc, Sound.ANVIL_BREAK, 1.0F, 1.0F);

	/*     */         }
	/* 109 */       }, 200L);
	}

	subiu.add(p);
	} else {
		if (!KitManager.getPlayer(e.getPlayer().getName()).hasKit(this)) {
			return;
		}
		
		if ((e.getPlayer().getItemInHand().getType() != Material.FIREBALL)) {
			return;
		}
		if (hasCooldown(p))
		/*     */       {
		/*  91 */         sendMessageCooldown(p);
		/*  92 */         return;
		/*     */       }

	/* 106 */            if (KitManager.getPlayer(p.getName()).hasKit()) {
	    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);

	/* 107 */           p.sendMessage(ChatColor.RED + "APERTE SHIFT PARA USAR O METEOR QUANDO ESTIVER NO ALTO!");
	/*     */         }
	}

	/*     */   }
	}
