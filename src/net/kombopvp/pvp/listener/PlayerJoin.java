package net.kombopvp.pvp.listener;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.bossbar.BossBar;
import me.neznamy.tab.api.bossbar.BossBarManager;
import me.neznamy.tab.api.event.player.PlayerLoadEvent;
import me.rafaelauler.ss.TagCommand;
import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.command.DarKit;
import net.kombopvp.pvp.command.VanishUtil;
import net.kombopvp.pvp.kit.KitManager;
import net.kombopvp.pvp.kit.KitManager2;
import net.kombopvp.pvp.warp.WaveWarp2;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.wavemc.core.bukkit.WaveBukkit;
import net.wavemc.core.bukkit.account.WavePlayer;
import net.wavemc.core.bukkit.item.ItemBuilder;

public class PlayerJoin implements Listener {
	  public static ArrayList<String> game = new ArrayList();
	  public static HashMap<Player , String> playerrealname = new HashMap();
	  public static ArrayList<Player> fall = new ArrayList();
	public CompletableFuture<Boolean> isVip(UUID who) {
		
		RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (provider != null) {
		    LuckPerms api = provider.getProvider();
		    return api.getUserManager().loadUser(who)
			        .thenApplyAsync(user -> {
			            Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
			            return inheritedGroups.stream().anyMatch(g -> g.getName().equals("diretor") || g.getName().equals("gold") || g.getName().equals("diamond") || g.getName().equals("emerald") || g.getName().equals("beta") || g.getName().equals("yt")  || g.getName().equals("builder")  || g.getName().equals("helper")  || g.getName().equals("mod")  || g.getName().equals("estagiario")  || g.getName().equals("coord")  || g.getName().equals("admin")  || g.getName().equals("diretor")  || g.getName().equals("dono")  || g.getName().equals("miniyt") || g.getName().equals("yt+") || g.getName().equals("streamer") || g.getName().equals("yt+") || g.getName().equals("apoiador"));
			        });
			}
		return null;
		
}
	  
	  @EventHandler
	  public void onMove(PlayerMoveEvent e) {
	   
	    Player p = e.getPlayer();
	    if (p.getLocation().getY() < -2 && !KitManager.getPlayer(p.getName()).hasKit() && WaveWarp2.SPAWN.hasPlayer(p.getName())) {
	      WaveWarp2.SPAWN.send(p, true);
	      p.sendMessage(ChatColor.GREEN + " Eu te trouxe de volta a segurança.");
	      return;
	    }
	    if (p.getLocation().getY() < -2 && !KitManager.getPlayer(p.getName()).hasKit() && !KitManager2.getPlayer(p.getName()).haskit2() && WaveWarp2.SPAWN.hasPlayer(p.getName())) {
		      WaveWarp2.SPAWN.send(p, true);

		      p.sendMessage(ChatColor.GREEN + " Eu te trouxe de volta a segurança.");
		      return;
		    }
	    else if (p.getLocation().getY() < -2 && !KitManager.getPlayer(p.getName()).hasKit() && WaveWarp2.LOBBY.hasPlayer(p.getName())) {
		      WaveWarp2.LOBBY.send(p, true);

		      p.sendMessage(ChatColor.GREEN + " Eu te trouxe de volta a segurança.");
		      return;
		    }
	  }
	  @EventHandler
	  public void onMove2(EntityDamageEvent e) {
	    if (!(e.getEntity() instanceof Player))
	      return; 
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL && WaveWarp2.SPAWN.hasPlayer(p.getName())) {
	    	if (!fall.contains(p)) {
	    		return;
	    	}
	    	if (p.getLocation().getY() > KomboPvP.getInstance().getConfig().getInt("SpawnAltura")) {
	    		return;
	    	}
	      e.setCancelled(true);
	      p.sendMessage(ChatColor.RED + "Você perdeu a proteção do spawn.");
	      fall.remove(p);
	      if (!Jump.caiu.containsKey(p.getName())) {
	    		Jump.caiu.put(p.getName(), true);
	    					}
	    }
	    } 
		    
	

	   

	

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Player p = e.getPlayer();
		   
		if (VanishUtil.has(player.getName())) {
			VanishUtil.remove(player.getName());
			player.sendMessage("§c§lVANISH §fVocê saiu do vanish.");
		}
		ViaAPI ap = Via.getAPI();
		if (ap.getPlayerVersion(player.getUniqueId()) < 498) {
			player.sendMessage("§6§lKOMBO §7-> §fUtilize a versão 1.14.4 ou superior do minecraft");
			player.sendMessage("§6§lKOMBO §7-> §fPara ganhar o dobro de coins e xp");
			player.sendMessage("§6§lKOMBO §7-> §fE evitar ficar bugado no bloco e mais bugs");
			player.sendMessage("§6§lKOMBO §7-> §fNão se preocupe. o pvp continuará da 1.8");
		}
		new BukkitRunnable() {
			@Override
			public void run() {
				if (ap.getPlayerVersion(player.getUniqueId()) < 498) {
					player.sendMessage("§6§lKOMBO §7-> §fUtilize a versão 1.14.4 ou superior do minecraft");
					player.sendMessage("§6§lKOMBO §7-> §fPara ganhar o dobro de coins e xp");
					player.sendMessage("§6§lKOMBO §7-> §fE evitar ficar bugado no bloco e mais bugs");
					player.sendMessage("§6§lKOMBO §7-> §fNão se preocupe. o pvp continuará da 1.8");
					player.playSound(p.getLocation(), Sound.ANVIL_LAND, 10, 10);
					
			}
			}}.runTaskTimer(KomboPvP.getInstance(), 10 , 7 * 60 * 20);
	
	
		if (!playerrealname.containsKey(player)) {
		playerrealname.put(player, player.getName());
		
		}
		ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
	
		if (Jump.recebeu.containsKey(p.getName())) {
			Jump.recebeu.remove(player.getName());
		}
	    player.getActivePotionEffects().forEach(potion -> player.removePotionEffect(potion.getType()));
	    
	    	    KitManager.getPlayer(player.getName()).removeKit();
	    	    player.sendTitle("", "");
	    	    player.getInventory().clear();
	    	    player.getInventory().setArmorContents(null);
	    	    player.setGameMode(GameMode.SURVIVAL);
	    	    player.setMaxHealth(20.0D);
	    	    e.setJoinMessage(null);
	    	    if (!fall.contains(p)) {
	    	    	fall.add(p);
	    	    }
	    	    WaveWarp2.LOBBY.send(player);
	    	    player.setHealth(player.getMaxHealth());
	    	    player.getActivePotionEffects().forEach(potion -> player.removePotionEffect(potion.getType()));
	    	    player.setFireTicks(0);
	    	    player.setFoodLevel(20);
	    	    player.getInventory().setHeldItemSlot(0);
	    	    if (Bukkit.getPluginManager().isPluginEnabled("TAB")) {
	            	   TabAPI apitab = TabAPI.getInstance();
	            	   if (TagCommand.tagatual.containsKey(player)) {
	            apitab.getPlayer(player.getName()).setTemporaryGroup(TagCommand.tagatual.get(player));
	            player.sendMessage(ChatColor.GREEN + "Sua tag selecionada foi restaurada.");
	            }
	            	   
	    	    }
	    	        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
	    			if (provider != null) {

	    			    LuckPerms api = provider.getProvider();
	    				Bukkit.dispatchCommand(player, "tag " + api.getUserManager().getUser(player.getName()).getPrimaryGroup().toLowerCase());
	    	    	    
	    		WaveBukkit.getExecutorService().submit(() -> {
	    			new BukkitRunnable() {
	    				@Override
	    				public void run() {
	    					if (!(p.getLocation().getY() > 145)) {
	    						return;
	    					}
	    						if (p.getInventory().getContents() != null) {
	    							return;
	    						}
	    						
	    						player.sendMessage("§c§lINFORMAÇÕES: §fSuas informações foram carregadas.");
	    			
	    				}}.runTaskTimer(KomboPvP.getInstance(), 0, 1 * 1L);
	    		});
	    		WaveBukkit.getExecutorService().submit(() -> {
	    			new BukkitRunnable() {
	    				@Override
	    				public void run() {
	    		    	    WaveWarp2.LOBBY.send(player);
	    			     
	    				}}.runTaskLater(KomboPvP.getInstance(), 20l);
	    		});
	    			
		player.setFlying(false);
		
		player.setGameMode(GameMode.SURVIVAL);
		player.setLevel(0);
		player.setFireTicks(0);
	}
	}
}