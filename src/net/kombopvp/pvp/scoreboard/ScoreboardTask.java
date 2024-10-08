package net.kombopvp.pvp.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardTask extends BukkitRunnable {

	private final ScoreboardBuilder builder;
	
	public ScoreboardTask(ScoreboardBuilder builder) {
		this.builder = builder;
	}
	
	@Override
	public void run() {
		Bukkit.getOnlinePlayers().stream().filter(
				online -> online.getScoreboard().getObjective("pvp") != null || online.getScoreboard().getObjective("pvp2")  != null || online.getScoreboard().getObjective("pvpb")  != null || online.getScoreboard().getObjective("pvpl") != null || online.getScoreboard().getObjective("pvppt") != null || online.getScoreboard().getObjective("pvp3") != null || online.getScoreboard().getObjective("pvp4") != null || online.getScoreboard().getObjective("pvp5") != null || online.getScoreboard().getObjective("pvp6") != null || online.getScoreboard().getObjective("pvp7")  != null || online.getScoreboard().getObjective("pvpg")  != null
		).forEach(builder::update);
	}
}
