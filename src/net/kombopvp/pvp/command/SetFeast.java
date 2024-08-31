package net.kombopvp.pvp.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import net.kombopvp.pvp.KomboPvP;



        public class SetFeast implements CommandExecutor {
            @Override
            public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
                if (!(sender instanceof Player)) {
                    return true;
                }
                if (!sender.hasPermission("*")) {
                    sender.sendMessage(ChatColor.RED + "Você não tem permissão");
                    return true;
                }
                Player player = (Player)sender;
                if (cmd.getName().equalsIgnoreCase("setfeast")) {
                    // Obtém a seção "MiniFeast" da configuração
                    ConfigurationSection config = KomboPvP.getInstance().getConfig().getConfigurationSection("MiniFeast");

                    // Verifica se a seção existe
                    if (config == null) {
                        config = KomboPvP.getInstance().getConfig().createSection("MiniFeast");
                    }

                    Location loc = player.getLocation();

                    // Define os valores dentro da seção
                    config.set("x", loc.getBlockX());
                    config.set("y", loc.getBlockY());
                    config.set("z", loc.getBlockZ());

                    // Salva a configuração
                    KomboPvP.getInstance().saveConfig();

                    player.sendMessage("§a§lFEAST §fVocê setou o feast com sucesso.");
                    return true;
                }
                return false;
            }
        }
