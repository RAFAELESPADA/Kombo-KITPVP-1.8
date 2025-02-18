package net.kombopvp.pvp;


import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.kombopvp.pvp.warp.WaveWarp2;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Arrays;

public class NPCRegister implements Listener {

    private JavaPlugin plugin;
   
    private Location location;

    public NPC getShopNPC() {
        return shopNPC;
    }

    private NPC shopNPC;

    public NPC getAssistenteNPC() {
        return assistenteNPC;
    }

    private NPC assistenteNPC;

    public NPC getComboNPC() {
        return comboNPC;
    }

    private NPC comboNPC;

    public NPC getGappleNPC() {
        return GappleNPC;
    }

    private NPC GappleNPC;

    public NPC getSumoNPC() {
        return sumoNPC;
    }

    private NPC sumoNPC;

    private NPC caixasNPC;


    public NPCRegister(JavaPlugin plugin) {
        this.plugin = plugin;
        
    }}
   

 

    


