package com.palmtreefever.WeatherVoting.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.palmtreefever.WeatherVoting.Main;

public abstract class Timer extends BukkitRunnable {
	
	private static int time = 61;
	private static int delayedTime = 6;

	public static void startTimer() {
		String sName = Main.plugin.getConfig().getString("ServerPrefix");
		new BukkitRunnable() {
			@Override
			public void run() {
				if (time > 0) {
					time--;
					//TODO:some how inform players about the time left without spamming the chat
					//System.out.println(time);
				} else {
					this.cancel();
					if(Arrays.votersKeep.size() > Arrays.votersClear.size()) {
						for(String players: Arrays.voters) {
							Player p = Bukkit.getPlayer(players);
							p.sendMessage((ChatColor.translateAlternateColorCodes('&', sName + ChatColor.AQUA + " KEEPING weather! " + "Votes to KEEP the weather: " + ChatColor.WHITE + Arrays.votersKeep.size() 
									+ ChatColor.AQUA + " : Votes to CLEAR the weather: " + ChatColor.WHITE + Arrays.votersClear.size())));
						}
						Arrays.clearArrays();
						Main.votingPeriod = false;
						time = 61;
						return;
					} else if(Arrays.votersClear.size() > Arrays.votersKeep.size()) {
						for(String players: Arrays.voters) {
							Player p = Bukkit.getPlayer(players);
							p.sendMessage((ChatColor.translateAlternateColorCodes('&', sName + ChatColor.AQUA + " CLEARING weather! " + "Votes to KEEP the weather: " + ChatColor.WHITE + Arrays.votersKeep.size() 
									+ ChatColor.AQUA + " : Votes to CLEAR the weather: " + ChatColor.WHITE + Arrays.votersClear.size())));
						}
						Bukkit.getWorlds().get(0).setStorm(false);
						Arrays.clearArrays();
						Main.votingPeriod = false;
						time = 61;
						return;
					} else if(Arrays.votersKeep.size() == Arrays.votersClear.size()) {
						for(String players: Arrays.voters) {
							Player p = Bukkit.getPlayer(players);
							p.sendMessage((ChatColor.translateAlternateColorCodes('&', sName + ChatColor.AQUA + " There was a draw! " + "Votes to KEEP the weather: " + ChatColor.WHITE + Arrays.votersKeep.size() 
									+ ChatColor.AQUA + " : Votes to CLEAR the weather: " + ChatColor.WHITE + Arrays.votersClear.size())));
						}
						Arrays.clearArrays();
						Main.votingPeriod = false;
						time = 61;
						return;
					}
				}
			}
		}.runTaskTimer(Main.plugin, 0, 20l);
	}
	
	public static void startDelayTimer() {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (delayedTime > 0) {
					delayedTime--;
					//System.out.println(delayedTime);
				} else {
					this.cancel();
					delayedTime = 6;
					if(Bukkit.getWorlds().get(0).hasStorm()) {
						StartVote.startweathervote();
						return;
					} else {
						return;
					}
				}
			}
		}.runTaskTimer(Main.plugin, 0, 20l);
	}
}