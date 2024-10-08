package net.kombopvp.pvp.command;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.kombopvp.pvp.inventory.StatusGUI;
import net.kombopvp.pvp.listener.Ranking;
import net.wavemc.core.bukkit.WaveBukkit;
import net.wavemc.core.bukkit.account.WavePlayer;

public class VerRank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("APENAS JOGADORES");
            return true;
        }
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("verrank") || command.getName().equalsIgnoreCase("profile") || command.getName().equalsIgnoreCase("status") || command.getName().equalsIgnoreCase("stats")) {
            if (args.length == 0) {
            	  StatusGUI.openGUI(player, player);
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage("§cPlayer não encontrado: §e" + args[0] + "§c.");
                return true;
            }
            
            StatusGUI.openGUI(player, target);
        }
        return false;
    }
}
